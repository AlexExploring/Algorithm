package DP.rob;

/**
 * ��ˢ����
 */
public class LC256 {

    /**
     * ˼·:
     * 1. �������η�ˢ���ӣ���ÿ�η�ˢ����ɫֻ����һ�䷿���йء�
     * 2. �����ǰ������Ҫˢ��ɫ����ôǰһ�䷿��ֻ������ɫ������ɫ
     * 3. ��ô��ǰ����ˢ��ɫ����ͻ��Ѿ��� ��ǰˢ��ɫ���� = min (ǰ��ˢ��ɫ���ѣ�ǰ��ˢ��ɫ����) + ��ǰ����ˢ��ɫ����
     * 4. ������ɫ�Դ����� dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0] ��ͬ��ɫ�ľͲ��ھ���
     */
    public int minCost(int[][] costs) {
        int len = costs.length;
        int[][] dp = new int[len][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < len; i++) {
            //��ǰΪ��ɫ
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            //��ǰΪ��ɫ
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            //��ǰΪ��ɫ
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));
    }
}
