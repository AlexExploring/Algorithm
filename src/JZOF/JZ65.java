package JZOF;

/**
 *链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng
 * -chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
 */
public class JZ65 {
    public static void main(String[] args) {
        int a = 9,b = 13;
        int res = a^b;
        System.out.println(res);
    }

    /**
     *迭代实现
     */
    public int add(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }

    /**
     *递归实现
     */
    public int add1(int a, int b) {
        if (a == 0 || b == 0)
            return a ^ b;
        return add1(a ^ b, (a & b) << 1);
    }

}