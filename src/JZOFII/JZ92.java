package JZOFII;

/**
 * ��ת�ַ� ����LC926��ͬ �� ���ַ�����ת������������
 */
public class JZ92 {

    /**
     * ��̬�滮��
     * ״̬���壺
     * 1. dp[i][0]��ʾǰi��Ԫ�أ�ʹ���һ��Ԫ��Ϊ0����С��ת����
     * 2. dp[i][1]��ʾǰi��Ԫ�أ�ʹ���һ��Ԫ��Ϊ1����С��ת����
     */
    public int minFlipsMonoIncr(String s) {
        int dp[][]=new int[s.length()][2];
        //��ʼ��
        dp[0][0]=s.charAt(0)=='0'?0:1;
        dp[0][1]=s.charAt(0)=='1'?0:1;
        //״̬ת��
        for (int i = 1; i <s.length() ; i++) {
            // ��0�� ��β��ǰһ���ַ�ֻ���� ��0��
            dp[i][0]=dp[i-1][0]+(s.charAt(i)=='0'?0:1);
            // ��1�� ��β��ǰһ���ַ��ȿ����� ��0��Ҳ������ ��1��, �ĸ�״̬��ת�������پ�ʹ���ĸ�״̬
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+(s.charAt(i)=='1'?0:1);
        }
        return Math.min(dp[s.length()-1][0],dp[s.length()-1][1]);
    }

    /**
     * �ռ临�Ӷ��Ż���
     * ʵ����ֻ��Ҫ��������״̬����dp[0][0]��dp[0][1]
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
