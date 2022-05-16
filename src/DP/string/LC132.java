package DP.string;

import java.util.Arrays;

/**
 * 最少回文分割 （和LC132相同：分割回文串2）
 */
public class LC132 {

    /**
     * 动态规划
     */
    public int minCut(String s) {
        int len = s.length();
        boolean[][] f = new boolean[len][len];

        // 边界1: 对角线，即单个字符，都是回文
        for(int i = 0; i < len; i++){
            f[i][i] = true;
        }
        // 边界2:对角线上侧紧邻斜线，即两个字符，判断是否相等，相等则为回文
        for(int i = 0; i < len - 1; i++){
            f[i][i + 1] = s.charAt(i) == s.charAt(i+ 1);
        }
        // 从下到上，边界1和边界2确定了两条斜线，所以只需要从倒数第三行开始往上补全右上三角
        for(int i = len - 3; i >= 0; i--){
            for(int j = i + 2; j < len; j++){
                f[i][j] = f[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        int [] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            // [0,i] 可以形成回文串，需要的分割次数为0
            if (f[0][i]) {
                dp[i] = 0;
            } else {
                // 枚举 0 <= j < i;
                for (int j = 0; j < i; j++) {
                    // 下标[j+1,i]的子串为回文串
                    if (f[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[len-1];
    }
}
