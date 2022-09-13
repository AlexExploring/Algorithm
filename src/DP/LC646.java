package DP;

import java.util.Arrays;

/**
 * �������
 *
 * ��Ŀ������n�����ԡ���ÿһ�������У���һ���������Ǳȵڶ�������С�����ڣ����Ƕ���һ�ָ����ϵ��
 * ���ҽ���b < cʱ������(c, d)�ſ��Ը���(a, b)���档������������ʽ������һ��������������һ��
 * ���Լ��ϣ��ҳ��ܹ��γɵ���������ĳ��ȡ��㲻��Ҫ�õ����е����ԣ���������κ�˳��ѡ�����е�
 * һЩ���������졣
 */
public class LC646 {

    /**
     * ��̬�滮
     */
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, (a, b) -> { return a[0] - b[0]; });
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    /**
     * ��̬�滮 �Ż� �Ӻ���ǰ����
     */
    public int findLongestChain1(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, (a, b) -> { return a[0] - b[0]; });
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[len - 1];
    }

    /**
     * ̰��
     *
     * ˼·��Ҫ��ѡ��������ĵ�һ������ʱ�����ŵ�ѡ������ѡ�ڶ���������С�ģ������ܸ���ѡ����
     * ���������¸���Ŀռ䡣�����һ�����Ժ�Ҫ���ڶ�������ʱ��Ҳ�ǰ�����ͬ��˼·������ʣ�µ�
     * �����У���һ��������������������£���ѡ�ڶ���������С�ġ�����������˼·�������Ƚ����밴
     * �յڶ�����������Ȼ��ͣ���жϵ�һ�������Ƿ����������ǰһ�����Եĵڶ������ּ��ɡ�
     */
    public int findLongestChain2(int[][] pairs) {
        int curr = Integer.MIN_VALUE, res = 0;
        Arrays.sort(pairs, (a, b) -> { return a[1] - b[1]; });
        for (int[] p : pairs) {
            if (curr < p[0]) {
                curr = p[1];
                res++;
            }
        }
        return res;
    }
}