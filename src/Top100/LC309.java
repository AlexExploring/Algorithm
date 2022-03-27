package Top100;

/**
 * 最佳买卖股票时机含冷冻期
 */
public class LC309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int len = prices.length;
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
