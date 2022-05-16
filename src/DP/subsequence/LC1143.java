package DP.subsequence;

/**
 * 最长公共子序列
 * 注意：子序列是不要求连续的
 */
public class LC1143 {

    /**
     * 其中 dp[i][j] 表示 text1[0:i] 和 text2[0:j] 的最长公共子序列的长度。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(),n = text2.length();
        int [][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j-1);
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 使用滚动数组优化空间复杂度
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length(),n = text2.length();
        int [] dp = new int[n+1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i-1);
            int upLeft = dp[0];
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j-1);
                // temp用来记录未被覆盖之前的dp[j], 它会在计算 j+1的时候作为upLeft用到
                int temp = dp[j];
                if (c1 == c2) {
                    dp[j] = upLeft + 1;
                }else {
                    dp[j] = Math.max(dp[j-1],dp[j]);
                }
                upLeft = temp;
            }
        }
        return dp[n];
    }
}
