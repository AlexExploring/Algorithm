package DP.math;

/**
 * 整数拆分
 */
public class LC343 {

    /**
     * 动态规划
     *
     * 1.要求长度为n（2 <= 2 <= 58）的绳子剪掉后的最大乘积，可以从比前面比n小的绳子转移而来
     * 2.用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积，dp[i]表示长度为i的绳子剪成m
     * 段后的最大乘积
     * 3.我们先把绳子剪掉第一段（长度为j），如果只剪掉长度为1，对最后的乘积无任何增益，所以从长度为2开始剪
     *
     *
     * 遍历过程中，只会有两个选择，减或者不减
     */
    public int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                //不减或减(1.将i拆分成j和i−j的和，且i−j不再拆分成多个正整数，此时的乘积是 j×(i−j);
                // 2.将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。  )
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    /**
     * 优化的动态规划
     */
    public int cuttingRope2(int n) {
        if(n < 4){
            return n - 1;
        }
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}
