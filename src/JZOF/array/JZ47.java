package JZOF.array;


public class JZ47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        dp[0][0]=grid[0][0];

        for (int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                //确保每一步最小，从而得到最小值
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
        if (m <=0 || n <= 0) return 0;//检查是否越界
        int [] dp = new int[n];
        //处理第一行
        dp[0] = grid[0][0];
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
