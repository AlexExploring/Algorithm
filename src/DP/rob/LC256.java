package DP.rob;

/**
 * 粉刷房子
 */
public class LC256 {

    /**
     * 思路:
     * 1. 我们依次粉刷房子，而每次粉刷的颜色只跟上一间房子有关。
     * 2. 如果当前房子想要刷红色，那么前一间房子只能是蓝色或者绿色
     * 3. 那么当前房子刷红色的最低花费就是 当前刷红色花费 = min (前面刷蓝色花费，前面刷绿色花费) + 当前房子刷红色花费
     * 4. 其余颜色以此类推 dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0] 不同颜色的就不在举例
     */
    public int minCost(int[][] costs) {
        int len = costs.length;
        int[][] dp = new int[len][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < len; i++) {
            //当前为红色
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            //当前为蓝色
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            //当前为绿色
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));
    }
}
