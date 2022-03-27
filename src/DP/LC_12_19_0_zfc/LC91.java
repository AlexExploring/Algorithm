package DP.LC_12_19_0_zfc;

/**
 * @author zhxspacex
 * @date 2020/12/14 21:56
 */

import java.util.Scanner;

/**
 *解码方法
 *
 *动态规划:自底向上+递推
 */
public class LC91 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(numDecodings(s));
    }

    public static int numDecodings(String s) {
        int len = s.length();
        //处理字符串为空和第一位为0的情况
        if (len == 0 || s.charAt(0) == '0') return 0;

        if (len < 2) return len;

        char [] chars = s.toCharArray();
        int [] dp = new int[len+1];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            //如果最后一位不是0则一定可以翻译
            dp[i] = chars[i] == '0' ? 0 : dp[i-1];
            int currentNum = 10*(chars[i-1]-'0') + (chars[i]-'0');
            if ((currentNum >=10 && currentNum <= 26)){
                if (i-2 < 0)
                    dp[i]++;
                else
                    dp[i] += dp[i-2];
            }
        }
        return dp[len-1];
    }

    /**
     *小优化
     * 状态：dp[i]是s[0...1]的解码方法
     */
    public static int numDecodings1(String s) {
        int len = s.length();
        //处理字符串为空和第一位为0的情况
        if (len == 0 || s.charAt(0) == '0') return 0;

        if (len < 2) return len;

        char [] chars = s.toCharArray();
        int [] dp = new int[len+1];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            //如果最后一位不是0则一定可以翻译
            dp[i] = chars[i] == '0' ? 0 : dp[i-1];
            int currentNum = 10*(chars[i-1]-'0') + (chars[i]-'0');
            if ((currentNum >=10 && currentNum <= 26)){
                if (i-2 < 0)
                    dp[i]++;
                else
                    dp[i] += dp[i-2];
            }
        }
        return dp[len-1];
    }

    /**
     *参考
     * 状态dp[]
     * 状态转移方程：dp[i+1] = dp[i]+dp[i-1];
     */
    public static int numDecodings2(String s){
        int length = s.length();
        if(length == 0 || s.charAt(0) == 0) return 0;

        int[] dp = new int[length+1];
        dp[0] = 1;

        for(int i=0;i<length;i++){
            dp[i+1] = s.charAt(i)=='0'?0:dp[i];
            if(i > 0 && (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6'))){
                dp[i+1] += dp[i-1];
            }
        }

        return dp[length];
    }

}
