package JZOFII;

/**
 * 翻转字符 （和LC926相同 ： 将字符串翻转到单调递增）
 */
public class JZ92 {

    /**
     * 动态规划：
     * 状态意义：
     * 1. dp[i][0]表示前i个元素，使最后一个元素为0的最小翻转次数
     * 2. dp[i][1]表示前i个元素，使最后一个元素为1的最小翻转次数
     */
    public int minFlipsMonoIncr(String s) {
        int dp[][]=new int[s.length()][2];
        //初始化
        dp[0][0]=s.charAt(0)=='0'?0:1;
        dp[0][1]=s.charAt(0)=='1'?0:1;
        //状态转移
        for (int i = 1; i <s.length() ; i++) {
            // ‘0’ 结尾则前一个字符只能是 ‘0’
            dp[i][0]=dp[i-1][0]+(s.charAt(i)=='0'?0:1);
            // ‘1’ 结尾则前一个字符既可以是 ‘0’也可以是 ‘1’, 哪个状态翻转次数最少就使用哪个状态
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+(s.charAt(i)=='1'?0:1);
        }
        return Math.min(dp[s.length()-1][0],dp[s.length()-1][1]);
    }

    /**
     * 空间复杂度优化：
     * 实际上只需要保存两个状态，即dp[0][0]和dp[0][1]
     */
    public int minFlipsMonoIncr1(String s) {
        int len = s.length();
        char[] words = s.toCharArray();
        int endWith0 = (words[0] == '0') ? 0 : 1;
        int endWith1 = (words[0] == '1') ? 0 : 1;

        for(int i=1;i<len;i++){
            int newEndsWith0 = endWith0 + (words[i] == '0' ? 0 : 1);
            endWith1 = Math.min(endWith0, endWith1) + (words[i] == '1' ? 0 : 1);
            endWith0 = newEndsWith0;
        }

        return Math.min(endWith0, endWith1);
    }
}
