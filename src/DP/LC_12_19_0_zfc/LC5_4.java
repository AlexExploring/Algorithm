package DP.LC_12_19_0_zfc;

//动态规划
//一个回文去掉两头后仍然是回文，
//状态：dp[i][j]表示子串s[i][j]是否为回文子串
//得到状态转移方程：dp[i][j]=(s[i] == s[j]) and dp[i+1][j-1];
//边界条件：j-1-(i+1)+1 < 2 （表达式[i+1,j-1]不构成区间，即长度严格小于2） 字符串的长度小于2时不用检查字符串是否回文,即j-i<3,
// 即j-i+1 < 4,当s[i...j]长度为2或者3时，不用检查子串是否回文
//由小规模问题到大规模问题，尽可能利用之前的解，得到新问题的解

import java.util.Scanner;

public class LC5_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        System.out.println(LongestPalindrome(s));
    }

    public static String LongestPalindrome(String s){
        int len = s.length();
        if (len < 2) return s;
        int maxLEN = 1;
        int begin = 0;

        boolean [][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char [] a = s.toCharArray();

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (a[i] != a[j]) {
                    dp[i][j] = false;
                }
                else {
                    if (j-i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                //只要dp[i][j]==true成立，就表示子串s[i...j]是回文，此时记录回文长度和起始位置
                //j-i+1表示当前字符串长度，
                if (dp[i][j] && j-i+1 > maxLEN){
                    maxLEN = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLEN);
    }
}
