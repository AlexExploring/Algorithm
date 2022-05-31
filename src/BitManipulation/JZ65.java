package BitManipulation;

/**
 * 不用加减乘除做加法
 *
 * 和LC371相同
 */
public class JZ65 {
    public static void main(String[] args) {
        System.out.println(new JZ65().add(9, 11));
    }

    /**
     *  位运算+迭代实现
     */
    public int add(int a, int b) {
        while(b != 0) {
            // c = 每位的进位
            int c = (a & b) << 1;
            // a = 非进位和
            a ^= b;
            // b = 进位
            b = c;
        }
        return a;
    }

    /**
     * 递归实现
     */
    public int add1(int a, int b) {
        if (a == 0 || b == 0)
            return a ^ b;
        return add1(a ^ b, (a & b) << 1);
    }

}