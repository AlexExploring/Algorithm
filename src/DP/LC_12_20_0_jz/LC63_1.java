package DP.LC_12_20_0_jz;

import java.util.Scanner;

public class LC63_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int [][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        System.out.println(uniquePathsWithObstacles1(a));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid.length==0||obstacleGrid[0].length==0) return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int [m+1][n+1];//dp中的初始值全为0
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1) continue;
                if(i==0&&j==0) dp[i][j]=1;
                else if(i==0) dp[i][j]=dp[i][j-1];
                else if(j==0) dp[i][j]=dp[i-1][j];
                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     *官方题解
     * 使用滚动数组
     */

    public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] dp = new int[m];

        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) { //由于只能往下走或往右走，对与边界来说，
                    //该行或该列剩余的dp[0]都应该为0
                    dp[j] = 0;
                    continue;
                }
                //j-1>=0 保证当前要计算的状态的坐标不在第一列，否则
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] = dp[j - 1]+dp[j];
                }
            }
        }
        return dp[m - 1];
    }
}
