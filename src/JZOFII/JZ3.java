package JZOFII;

/**
 * ǰ n �����ֶ������� 1 �ĸ���
 */
public class JZ3 {

    public int[] countBits(int n) {
        int [] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int cur = i;
            while (cur != 0) {
                ans[i] += cur&1;
                cur>>=1;
            }
        }
        return ans;
    }

    /**
     * ��̬�滮:
     *
     * �������ǿ��Եõ����µ�״̬ת�Ʒ��̣�
     * dp[i] = dp[i-1]����iΪ����
     * dp[i] = dp[i/2]����iΪż��
     *
     * �����������ԣ�(i-1)/2�ȼ���i/2
     */
    public int[] countBits1(int n){
        int [] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i>>1] + (i&1);
        }
        return ans;
    }
}
