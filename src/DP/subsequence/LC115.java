package DP.subsequence;

/**
 * ��ͬ��������
 */
public class LC115 {

    public static void main(String[] args) {
        System.out.println(new LC115().numDistinct("rabbbit", "rabbit"));
    }

    /**
     * dp[i][j]��ʾ�ַ���s[0 ... i]��ǰi���ַ��������ַ����е�����
     * ����t[0 ... j]��ǰj���ַ�������������Ŀ
     */
    public int numDistinct(String s, String t) {
        int lens = s.length(),lent = t.length();

        if (lens < lent) return 0;

        int [][] dp = new int[lens+1][lent+1];
        //���ַ������κ��ַ�����������
        for (int i = 0; i <= lens; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lent; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    //��s[i] = t[j]������s_i�е�����t_j�������У�����s[i]����dp[i-1][j-1]��������������dp[i-1][j]��
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    //�����ʱ��s_i�е�����t_j�����У���Ȼ������s[i],��s_i-1 �� s_i��t_j��������һ����
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[lens][lent];
    }

    /**
     * ʱ�临�Ӷ��Ż�
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
     * �ռ临�Ӷ��Ż�
     */
    public int numDistinct2(String s, String t) {
        int lens = s.length(), lent = t.length();

        if(lens < lent) return 0; // s����С��t����ֱ�ӷ���0

        int[] dp = new int[lent + 1]; // ע�������С��dp�������
        dp[0] = 1;

        for(int i = 1; i <= lens; i++){
            for(int j = lent; j >= 1; j--){ // ע������
                if(s.charAt(i-1) == t.charAt(j-1)) // ʡȥ�˲���ʱ��dp[j] = dp[j]
                    dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[lent];
    }

    /**
     * ʱ�临�Ӷ��Ż�
     */
    public int numDistinct3(String s, String t) {
        int lens = s.length(), lent = t.length();

        if(lens < lent) return 0; // s����С��tʱ��ֱ�ӷ���0

        int[] dp = new int[lent + 1]; // ע�������С��dp�������
        dp[0] = 1;

        for(int i = 1; i < lens + 1; i++){
            int ends = Math.min(lent,i);
            for(int j = ends; j >= 1; j--){ // ע������
                if(s.charAt(i-1) == t.charAt(j-1)) // ʡȥ�˲���ʱ��dp[j] = dp[j]
                    dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[lent];
    }
}
