package BitManipulation;

/**
 * 题目：给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 */
public class LC338 {

    /**
     * 从0到n依次统计每个数的每一位
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int cur = i;
            while (cur != 0) {
                ans[i] += cur & 1;
                cur >>= 1;
            }
        }
        return ans;
    }

    /**
     * 动态规划:
     *
     * 所以我们可以得到如下的状态转移方程：
     * dp[i] = dp[i-1]，当i为奇数
     * dp[i] = dp[i/2]，当i为偶数
     *
     * 对于奇数而言，(i-1)/2等价于i/2
     */
    public int[] countBits1(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i>>1] + (i&1);
        }
        return ans;
    }
}