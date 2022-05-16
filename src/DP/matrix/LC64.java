package DP.matrix;


//问题描述
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//**说明：**每次只能向下或者向右移动一步。
public class LC64 {

    /**
     * 动态规划
     */
    public int uniquePaths(int [][] grid){
        int m = grid.length,n = grid[0].length;

        int dp[][] = new int[m][n];
        dp[0][0]=grid[0][0];

        //第一行只能从dp[0][0]向右到达
        for (int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        //第一列只能从dp[0][0]向下到达
        for (int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                //确保每一步最小，从而得到最小值
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];//grid[i][j]表示网格中的值
            }
        }

        return dp[m-1][n-1];
    }

    /**
     * 滚动数组优化
     */
    public int uniquePaths1(int [][] grid){
        int m = grid.length,n = grid[0].length;

        int [] dp = new int[n];
        //处理第一行
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] += dp[i-1]+grid[0][i];
        }

        for (int i=1;i<m;i++){
            //第一列只能从上到下
            dp[0] += grid[i][0];
            for (int j=1;j<n;j++){
                dp[j] = Math.min(dp[j],dp[j-1])+grid[i][j];
            }
        }
        return dp[n-1];
    }

    /**
     * 使用滚动数组优化空间复杂度
     */
    public int uniquePaths2(int [][] grid){
        int m = grid.length,n = grid[0].length;

        int [] dp = new int[n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0){
                    if (j==0)dp[j] = grid[0][0];
                    else dp[j]=dp[j-1]+grid[0][j];
                } else if (j==0) dp[j]+=grid[i][j];
                else dp[j] = Math.min(dp[j],dp[j-1])+grid[i][j];
            }
        }
        return dp[n-1];
    }
}
