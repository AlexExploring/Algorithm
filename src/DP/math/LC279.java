package DP.math;

/**
 * 完全平方数
 *
 * 题目：给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 */
public class LC279 {

    /**
     * 动态规划
     */
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]+1);
            }
            f[i] = minn;
        }
        return f[n];
    }
}
