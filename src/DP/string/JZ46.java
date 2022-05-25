package DP.string;

/**
 * �����ַ�����ַ���
 */
public class JZ46 {

    /**
     * dp[i] ��ʾ���Ե�iλ(������)��β�����ֵķ��뷽��������
     * ״̬ת�Ʒ��̣�dp[i] = dp[i-1]+dp[i-2]  (�����iλ�͵�i-1λ��ɵ���λ���ֿ��Ա�����)
     * ����dp[i] = dp[i-1]
     *
     */
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) return len;

        char [] chars = s.toCharArray();
        //dp[i]��ʾnums[0...i)�ܷ�����ַ�����������
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
