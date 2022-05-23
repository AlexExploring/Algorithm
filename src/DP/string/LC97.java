package DP.string;

/**
 * 交错字符串  (和LC62类似)
 */
public class LC97 {

    /**
     * 题解链接：https://leetcode.cn/problems/interleaving-string/solution/lei-si-lu-jing-wen-ti-zhao-zhun-zhuang-tai-fang-ch/
     *
     * 状态定义: boolean[][] dp ，dp[i][j] 代表 s1 前 i 个字符与 s2 前 j
     * 个字符拼接成 s3 的 i+j 字符，也就是存在目标路径能够到达 i ,j
     *
     * 状态方程：
     * 边界 1：dp[0][0] = true;
     * 边界 2：if i=0 : dp[0]dp[j] = s2[0-j) equals s3[0,j) 遇到 false 后面可以直接省略
     * 边界 3：if j=0 : dp[i]dp[0] = s1[0-i) equals s3[0,i) 遇到 false 后面可以直接省略
     * 其他情况，到达（i，j）可能由（i-1,j）点向下一步，选择 s1[i-1] 到达；也可能由 （i,j-1） 点向右一步，选择 s2[j-1] 到达；
     * dp[i,j] = (dp[i-1][j] &&s3[i+j-1] == s1[i-1]) || (dp[i][j-1] && s3[i+j-1] == s2[j-1])
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(),len2 = s2.length(),len3 = s3.length();

        if (len1+len2 != len3) return false;

        boolean [][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for (int i = 1; i <= len1 && s1.charAt(i-1) == s3.charAt(i-1); i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len2 && s2.charAt(i-1) == s3.charAt(i-1); i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = (dp[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1))
                        || (dp[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1));
            }
        }
        return dp[len1][len2];
    }

    /**
     * 官方题解
     */
    public boolean isInterleave1(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; ++i) {
            for (int j = 0; j <= len2; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return dp[len1][len2];
    }

    public boolean isInterleave3(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();

        if (len1 + len2 != len3) {
            return false;
        }

        boolean[] dp = new boolean[len2 + 1];

        dp[0] = true;
        for (int i = 0; i <= len1; ++i) {
            for (int j = 0; j <= len2; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return dp[len2];
    }
}
