package DP.matrix;

/**
 * 礼物的最大价值
 */
public class JZ47 {
    public int maxValue(int[][] grid) {
        int m = grid.length,n = grid[0].length;

        int dp[][] = new int[m][n];

        dp[0][0]=grid[0][0];
        //第一列只能从上到下而来
        for (int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //第一行只能从左到右
        for (int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                //确保每一步最大，从而得到最大值
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];//grid[i][j]表示网格中的值
            }
        }

        return dp[m-1][n-1];
    }

    /**
     *滚动数组优化
     */
    public static int uniquePaths2(int [][] grid){
        int m = grid.length,n = grid[0].length;

        int [] dp = new int[n];
        dp[0] = grid[0][0];
        //处理第一行
        for (int i = 1; i < n; i++) {
            dp[i] += dp[i-1]+grid[0][i];
        }

        for (int i=1;i<m;i++){
            dp[0] += grid[i][0];
            for (int j=1;j<n;j++){
                dp[j] = Math.max(dp[j],dp[j-1])+grid[i][j];
            }
        }

        return dp[n-1];
    }
}
