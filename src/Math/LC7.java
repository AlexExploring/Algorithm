package Math;

/**
 *  ������ת
 *
 *  ��ans * 10 + pop < MIN_VALUE��������������
 * ������ ans < MIN_VALUE / 10 �� ����pop��Ҫ��� ʱ����һ�����
 * ������ ans == MIN_VALUE / 10 �� pop < -8 ʱ����һ�������8��-2^31�ĸ�λ��
 *
 * ���ӣ�https://leetcode-cn.com/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/
 */
public class LC7 {

    public static void main(String[] args) {
        System.out.println(13%10);
    }

    public int reverse(int x) {
        int ans = 0;

        while (x != 0) {
            int tem  = x%10;

            //��ת�������ж��Ƿ�����������������ֱ�ӷ���0
            if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE / 10 && tem > 7))
                return 0;
            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE / 10 && tem < -8))
                return 0;

            ans = ans*10 + tem;
            x/=10;
        }

        return ans;
    }

    /**
     * ��ans == Integer.MAX_VALUE������Ҫ�����������x�����λdigit����digit��<=2�ģ�
     * ����ans == Integer.MAX_VALUEʱ��һ������������
     */
    public int reverse1(int x) {
        int rev = 0;

        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x%10;
            x/=10;
            rev = rev*10 + digit;
        }

        return rev;
    }
}
