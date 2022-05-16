package DP.subsequence;

/**
 * �����������
 * ע�⣺�������ǲ�Ҫ��������
 */
public class LC1143 {

    /**
     * ���� dp[i][j] ��ʾ text1[0:i] �� text2[0:j] ������������еĳ��ȡ�
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(),n = text2.length();
        int [][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i-1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j-1);
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * ʹ�ù��������Ż��ռ临�Ӷ�
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length(),n = text2.length();
        int [] dp = new int[n+1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i-1);
            int upLeft = dp[0];
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j-1);
                // temp������¼δ������֮ǰ��dp[j], �����ڼ��� j+1��ʱ����ΪupLeft�õ�
                int temp = dp[j];
                if (c1 == c2) {
                    dp[j] = upLeft + 1;
                }else {
                    dp[j] = Math.max(dp[j-1],dp[j]);
                }
                upLeft = temp;
            }
        }
        return dp[n];
    }
}
