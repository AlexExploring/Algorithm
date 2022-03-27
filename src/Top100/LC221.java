package Top100;

/**
 * ���������
 *
 * ������Ŀ LC1277
 */
public class LC221 {

    /**
     * ��̬�滮
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int [][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]=='1'){
                    if (i==0||j==0) dp[i][j] = 1;
                    else {
                        dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide*maxSide;
    }
}
