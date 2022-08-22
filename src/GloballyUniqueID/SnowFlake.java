package GloballyUniqueID;

/**
 * twitter的snowflake算法 -- java实现
 *
 * @author wjj
 */
public class SnowFlake {

    /**
     * 起始的时间戳
     */
    private final static long START_STMP = 1288834974657L; // 41位

    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 12; //序列号占用的位数
    private final static long MACHINE_BIT = 5;   //机器标识占用的位数
    private final static long DATACENTER_BIT = 5;//数据中心占用的位数

    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);//0-31
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT); //0-31
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);//0-4095

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    private long datacenterId;  //数据中心
    private long machineId;     //机器标识
    private long sequence = 0L; //序列号
    private long lastStmp = -1L;//上一次时间戳

    public SnowFlake(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * 产生下一个ID
     *
     * @return
     */
    public synchronized long nextId() {
        long currStmp = getNewstmp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp == lastStmp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStmp = currStmp;

        return (currStmp - START_STMP) << TIMESTMP_LEFT //时间戳部分，占41位 左移22位
                | datacenterId << DATACENTER_LEFT       //数据中心部分占5位，左移17位
                | machineId << MACHINE_LEFT             //机器标识部分占5位，左移10位
                | sequence;                             //序列号部分占12位
    }

    private long getNextMill() {
        long mill = getNewstmp();
        while (mill <= lastStmp) {
            mill = getNewstmp();
        }
        return mill;
    }

    private long getNewstmp() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        // 数据中心 id 从 0 - 31 ,机器 id 从 0-31
        // 两者的位数可以自由调整，也可以 10 位的机器id，0位的数据中心id，最多部署 1024个节点
        SnowFlake snowFlake = new SnowFlake(31, 31);

        for (int i = 0; i < 50; i++) {
            System.out.println(snowFlake.nextId());
        }
        //System.out.println(Long.toBinaryString(START_STMP));
        //System.out.println(Long.toBinaryString(System.currentTimeMillis()));
    }
}