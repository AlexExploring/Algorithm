package JZOFII;

/**
 * 前 n 个数字二进制中 1 的个数
 */
public class JZ3 {

    public int[] countBits(int n) {
        int [] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int cur = i;
            while (cur != 0) {
                ans[i] += cur&1;
                cur>>=1;
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
    public int[] countBits1(int n){
        int [] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i>>1] + (i&1);
        }
        return ans;
    }
}
