package Top100;

/**
 *  整数反转
 *
 *  从ans * 10 + pop < MIN_VALUE这个溢出条件来看
 * 当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
 * 当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数
 *
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/
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
