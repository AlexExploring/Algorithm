package Top100;

/**
 * 完全平方数
 */
public class LC279 {

    /**
     * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
     *
     * 动态规划
     */
    public int numSquares(int n) {
        int [] f = new int[n];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                minn = Math.min(minn,f[i-j*j]);
            }
            f[i] = minn+1;
        }
        return f[n];
    }
}
