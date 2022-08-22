package GloballyUniqueID;

/**
 * twitter��snowflake�㷨 -- javaʵ��
 *
 * @author wjj
 */
public class SnowFlake {

    /**
     * ��ʼ��ʱ���
     */
    private final static long START_STMP = 1288834974657L; // 41λ

    /**
     * ÿһ����ռ�õ�λ��
     */
    private final static long SEQUENCE_BIT = 12; //���к�ռ�õ�λ��
    private final static long MACHINE_BIT = 5;   //������ʶռ�õ�λ��
    private final static long DATACENTER_BIT = 5;//��������ռ�õ�λ��

    /**
     * ÿһ���ֵ����ֵ
     */
    private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);//0-31
    private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT); //0-31
    private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);//0-4095

    /**
     * ÿһ���������λ��
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    private long datacenterId;  //��������
    private long machineId;     //������ʶ
    private long sequence = 0L; //���к�
    private long lastStmp = -1L;//��һ��ʱ���

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
     * ������һ��ID
     *
     * @return
     */
    public synchronized long nextId() {
        long currStmp = getNewstmp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp == lastStmp) {
            //��ͬ�����ڣ����к�����
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //ͬһ������������Ѿ��ﵽ���
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            //��ͬ�����ڣ����к���Ϊ0
            sequence = 0L;
        }

        lastStmp = currStmp;

        return (currStmp - START_STMP) << TIMESTMP_LEFT //ʱ������֣�ռ41λ ����22λ
                | datacenterId << DATACENTER_LEFT       //�������Ĳ���ռ5λ������17λ
                | machineId << MACHINE_LEFT             //������ʶ����ռ5λ������10λ
                | sequence;                             //���кŲ���ռ12λ
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
        // �������� id �� 0 - 31 ,���� id �� 0-31
        // ���ߵ�λ���������ɵ�����Ҳ���� 10 λ�Ļ���id��0λ����������id����ಿ�� 1024���ڵ�
        SnowFlake snowFlake = new SnowFlake(31, 31);

        for (int i = 0; i < 50; i++) {
            System.out.println(snowFlake.nextId());
        }
        //System.out.println(Long.toBinaryString(START_STMP));
        //System.out.println(Long.toBinaryString(System.currentTimeMillis()));
    }
}