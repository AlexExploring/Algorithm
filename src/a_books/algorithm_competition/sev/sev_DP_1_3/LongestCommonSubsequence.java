package a_books.algorithm_competition.sev.sev_DP_1_3;

import java.util.Scanner;

/**
 * 两个序列的最长公共子序列
 *
 * hdu1159
 */

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = new String(),s2 = new String();
        while(scan.hasNext()){
            s1 = scan.next();
            s2 = scan.next();
            int [][] dp = new int[s1.length()+1][s2.length()+1];
            System.out.println(LCS(s1,s2,dp));
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

    public static int LCS(String s1,String s2,int [][] dp){
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s2.charAt(j-1)==s1.charAt(i-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
