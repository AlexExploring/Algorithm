package DP.buyStock;

/**
 * 最佳买卖股票时机含冷冻期
 *
 * 注意：可多次买卖，卖出股票后无法在第二天买入（冷冻期）
 */
public class LC309 {

    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 0) return 0;

        int [][] f = new int[len][3];
        f[0][0] = -prices[0];

        for (int i = 0; i < len; i++) {
            f[i][0] = Math.max(f[i-1][0],f[i-1][2]-prices[i]);
            f[i][1] = f[i-1][0] + prices[i];
            f[i][2] = Math.max(f[i-1][1],f[i-1][2]);
        }
        return Math.max(f[len-1][1],f[len-1][2]);
    }
}
