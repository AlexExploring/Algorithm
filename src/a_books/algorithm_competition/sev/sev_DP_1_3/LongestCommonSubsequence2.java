package a_books.algorithm_competition.sev.sev_DP_1_3;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = new String(),s2 = new String();
        while (scan.hasNext()){
            s1 = scan.nextLine();
            s2 = scan.nextLine();
            int [][] dp = new int[2][Math.max(s1.length(),s2.length())+1];
            System.out.println(LCS(s1,s2,dp));
        }
    }

    public static int LCS(String s1,String s2,int [][] dp){
        if (s1.length()>s2.length()){
            String t = s1;s1 = s2;s2 = t;
        }
        System.out.println("s1"+s1+"  s2="+s2);

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[(i%2)][j] = dp[(i-1)%2][j-1]+1;

                }else {
                    dp[(i%2)][j] = Math.max(dp[(i-1)%2][j],dp[(i%2)][j-1]);
                }
            }
            for (int j = 0; j < 2; j++) {
                System.out.println(Arrays.toString(dp[j]));
            }
            System.out.println("......................................");
        }
        return dp[s1.length()%2][s2.length()];
    }
}
