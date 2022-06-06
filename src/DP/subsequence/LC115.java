package DP.subsequence;

/**
 * 不同的子序列
 */
public class LC115 {

    public static void main(String[] args) {
        System.out.println(new LC115().numDistinct("rabbbit", "rabbit"));
    }

    /**
     * dp[i][j]表示字符串s[0 ... i]（前i个字符）的子字符串中等于字
     * 符串t[0 ... j]（前j个字符）的子序列数目
     */
    public int numDistinct(String s, String t) {
        int lens = s.length(),lent = t.length();

        if (lens < lent) return 0;

        int [][] dp = new int[lens+1][lent+1];
        //空字符串是任何字符串的子序列
        for (int i = 0; i <= lens; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lent; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    //若s[i] = t[j]：假设s_i中的所有t_j子序列中，包含s[i]的有dp[i-1][j-1]个，不包含的有dp[i-1][j]个
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    //不相等时，s_i中的所有t_j子序列，必然不包含s[i],即s_i-1 和 s_i中t_j的数量是一样的
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[lens][lent];
    }

    /**
     * 时间复杂度优化
     */
    public int numDistinct1(String s, String t) {
        int lens = s.length(),lent = t.length();

        if (lens < lent) return 0;

        int [][] dp = new int[lens+1][lent+1];
        for (int i = 0; i <= lens; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= lens; i++) {
            int ends = Math.min(lent,i);
            for (int j = 1; j <= ends; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else dp[i][j] = dp[i-1][j];
            }
        }

        return dp[lens][lent];
    }

    /**
     * 空间复杂度优化
     */
    public int numDistinct2(String s, String t) {
        int lens = s.length(), lent = t.length();

        if(lens < lent) return 0; // s长度小于t长度直接返回0

        int[] dp = new int[lent + 1]; // 注意数组大小由dp定义决定
        dp[0] = 1;

        for(int i = 1; i <= lens; i++){
            for(int j = lent; j >= 1; j--){ // 注意逆序
                if(s.charAt(i-1) == t.charAt(j-1)) // 省去了不等时的dp[j] = dp[j]
                    dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[lent];
    }

    /**
     * 时间复杂度优化
     */
    public int numDistinct3(String s, String t) {
        int lens = s.length(), lent = t.length();

        if(lens < lent) return 0; // s长度小于t时间直接返回0

        int[] dp = new int[lent + 1]; // 注意数组大小由dp定义决定
        dp[0] = 1;

        for(int i = 1; i < lens + 1; i++){
            int ends = Math.min(lent,i);
            for(int j = ends; j >= 1; j--){ // 注意逆序
                if(s.charAt(i-1) == t.charAt(j-1)) // 省去了不等时的dp[j] = dp[j]
                    dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[lent];
    }
}
