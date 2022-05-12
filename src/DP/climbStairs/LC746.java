package DP.climbStairs;

/**
 * ��¥�ݵ����ٳɱ�
 */
public class LC746 {

    /**
     * ˼·�������i��̨�׵Ľ��ݶ�������С���ѣ�������ѡ��
     * 1. ���̤���˵�i��̨�ף���С����dp[i]������һ�������i��̨��¥�㶥����
     * 2. ���̤���˵�i-1��̨�ף���С����dp[i-1]���������������i��̨��ֱ�ӵ����i��̨�׵Ľ��ݶ�����
     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int [] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
        }

        return Math.min(dp[len-1],dp[len-2]);
    }

    /**
     * �ռ临�Ӷ��Ż�
     */
    public int minCostClimbingStairs1(int[] cost) {
        int len = cost.length;
        for (int i = 2; i < len; i++) {
            cost[i] += Math.min(cost[i-2],cost[i-1]);
        }

        return Math.min(cost[len-1],cost[len-2]);
    }
}
