package DP.buyStock;

/**
 * 最佳买卖股票时机含冷冻期
 *
 * 注意：可多次买卖，卖出股票后无法在第二天买入（冷冻期）
 */
public class LC309 {

    /**
     * 动态规划
     *
     * 我们用 f[i]表示第 i 天结束之后的「累计最大收益」。根据题目描述，由于我们最多只
     * 能同时买入（持有）一支股票，并且卖出股票后有冷冻期的限制，因此我们会有三种不同的状态：
     * 1. 我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]；
     * 2. 我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][1]；
     * 3. 我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][2]。
     *
     * 题解：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 0) return 0;

        int [][] f = new int[len][3];
        //在第 0天时，如果持有股票，那么只能是在第 0 天买入的，对应负收益 -prices[0];
        f[0][0] = -prices[0];

        for (int i = 0; i < len; i++) {
            f[i][0] = Math.max(f[i-1][0],f[i-1][2]-prices[i]);
            f[i][1] = f[i-1][0] + prices[i];
            f[i][2] = Math.max(f[i-1][1],f[i-1][2]);
        }
        return Math.max(f[len-1][1],f[len-1][2]);
    }
}
