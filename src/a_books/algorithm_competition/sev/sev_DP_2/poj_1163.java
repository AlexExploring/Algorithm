package a_books.algorithm_competition.sev.sev_DP_2;

import java.util.Scanner;

/**
 *类似于蓝桥杯一道省赛真题
 *
 * 题目来源，poj1163

 */
public class poj_1163 {

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
        System.out.println(dfs(1,1,n,map,dp));
    }

    // 记忆化搜索，在递归过程中记录计算过的状态
    public static int dfs(int i,int j,int n,int [][] map,int [][] dp){
        if (i == n)
            return map[i][j];
        if (dp[i][j]>=0) //也可以不要这一步，不过需要进行大量的重复计算，需要消耗大量的时间
            return dp[i][j];
        return dp[i][j] = Math.max(dfs(i+1,j,n,map,dp),dfs(i+1,j+1,n,map,dp))+map[i][j];
    }
}
