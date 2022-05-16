package DP.string;

import java.util.Arrays;

/**
 * ���ٻ��ķָ� ����LC132��ͬ���ָ���Ĵ�2��
 */
public class LC132 {

    /**
     * ��̬�滮
     */
    public int minCut(String s) {
        int len = s.length();
        boolean[][] f = new boolean[len][len];

        // �߽�1: �Խ��ߣ��������ַ������ǻ���
        for(int i = 0; i < len; i++){
            f[i][i] = true;
        }
        // �߽�2:�Խ����ϲ����б�ߣ��������ַ����ж��Ƿ���ȣ������Ϊ����
        for(int i = 0; i < len - 1; i++){
            f[i][i + 1] = s.charAt(i) == s.charAt(i+ 1);
        }
        // ���µ��ϣ��߽�1�ͱ߽�2ȷ��������б�ߣ�����ֻ��Ҫ�ӵ��������п�ʼ���ϲ�ȫ��������
        for(int i = len - 3; i >= 0; i--){
            for(int j = i + 2; j < len; j++){
                f[i][j] = f[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        int [] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            // [0,i] �����γɻ��Ĵ�����Ҫ�ķָ����Ϊ0
            if (f[0][i]) {
                dp[i] = 0;
            } else {
                // ö�� 0 <= j < i;
                for (int j = 0; j < i; j++) {
                    // �±�[j+1,i]���Ӵ�Ϊ���Ĵ�
                    if (f[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[len-1];
    }
}
