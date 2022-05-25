package DP.string;

/**
 * 把数字翻译成字符串
 */
public class JZ46 {

    /**
     * dp[i] 表示，以第i位(从左到右)结尾的数字的翻译方案数量。
     * 状态转移方程：dp[i] = dp[i-1]+dp[i-2]  (如果第i位和第i-1位组成的两位数字可以被翻译)
     * 否则：dp[i] = dp[i-1]
     *
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) return len;

        char [] chars = s.toCharArray();
        //dp[i]表示nums[0...i)能翻译成字符串的种类数
        int [] dp = new int[len+1];
        dp[0] = 1;dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            dp[i] = dp[i-1];
            int currentNum = 10*(chars[i-2]-'0') + (chars[i-1]-'0');
            if (currentNum > 9 && currentNum < 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }
}
