package DP.climbStairs;

/**
 * 爬楼梯的最少成本
 */
public class LC746 {

    /**
     * 思路：到达第i级台阶的阶梯顶部的最小花费，有两个选择：
     * 1. 最后踏上了第i级台阶，最小花费dp[i]，再迈一步到达第i级台阶楼层顶部；
     * 2. 最后踏上了第i-1级台阶，最小花费dp[i-1]，再迈两步跨过第i级台阶直接到达第i级台阶的阶梯顶部。
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
     * 空间复杂度优化
     */
    public int minCostClimbingStairs1(int[] cost) {
        int len = cost.length;
        for (int i = 2; i < len; i++) {
            cost[i] += Math.min(cost[i-2],cost[i-1]);
        }

        return Math.min(cost[len-1],cost[len-2]);
    }
}
