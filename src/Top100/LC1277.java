package Top100;

/**
 * 相似题目
 * LC221
 *
 * 题解：https://leetcode-cn.com/problems/count-square-submatrices-with-al
 * l-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/
 */
public class LC1277 {

    public int countSquares(int[][] matrix) {
        int [][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                }
                else if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
