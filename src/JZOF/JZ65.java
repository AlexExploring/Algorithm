package JZOF;

/**
 *���ӣ�https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng
 * -chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
 */
public class JZ65 {
    public static void main(String[] args) {
        int a = 9,b = 13;
        int res = a^b;
        System.out.println(res);
    }

    /**
     *����ʵ��
     */
    public int add(int a, int b) {
        while(b != 0) { // ����λΪ 0 ʱ����
            int c = (a & b) << 1;  // c = ��λ
            a ^= b; // a = �ǽ�λ��
            b = c; // b = ��λ
        }
        return a;
    }

    /**
     *�ݹ�ʵ��
     */
    public int add1(int a, int b) {
        if (a == 0 || b == 0)
            return a ^ b;
        return add1(a ^ b, (a & b) << 1);
    }

}