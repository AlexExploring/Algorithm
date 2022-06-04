package Top100;

/**
 *  ������ת
 *
 *  ��ans * 10 + pop < MIN_VALUE��������������
 * ������ ans < MIN_VALUE / 10 �� ����pop��Ҫ��� ʱ����һ�����
 * ������ ans == MIN_VALUE / 10 �� pop < -8 ʱ����һ�������8��-2^31�ĸ�λ��
 *
 * ���ߣ�guanpengchn
 * ���ӣ�https://leetcode-cn.com/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/
 */
public class LC7 {
    public int reverse(int x) {
        int ans = 0;
        while (x!=0) {
            int tem  = x%10;
            if (ans>Integer.MAX_VALUE/10)
                return 0;
            if (ans<Integer.MIN_VALUE/10)
                return 0;
            ans = ans*10 + tem;
            x/=10;
        }
        return ans;
    }
}
