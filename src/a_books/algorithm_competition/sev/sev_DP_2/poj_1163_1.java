package a_books.algorithm_competition.sev.sev_DP_2;

import java.util.Scanner;

public class poj_1163_1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [][] map = new int[n+1][n+1];
        int [][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                map[i][j] = scan.nextInt();
                dp[i][j] = -1;
            }
        }
        System.out.println(dp(n,map,dp));
    }

    //动态规划
    public static int dp(int n,int [][] map,int [][] dp){
        for (int i = 1; i <= n; i++) {
            dp[n][i] = map[n][i];  //先计算最后一层
        }
        for (int i = n-1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = map[i][j] + Math.max(dp[i+1][j],dp[i+1][j+1]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
        return dp[1][1];
    }
}
