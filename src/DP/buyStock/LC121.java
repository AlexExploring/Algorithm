package DP.buyStock;

/**
 * 买卖股票的最佳时机I
 *
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第
 * i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出
 * 该股票。设计一个算法来计算你所能获取的最大利润。
 */
public class LC121 {

    /**
     * 动态规划：注意只能买卖一次,所以一次遍历即可
     */
    public static int maxProfit(int[] prices){
        int len = prices.length;
        if (len <= 1) return 0;

        int minPrice = Integer.MAX_VALUE;
        int max_profit = 0;

        for(int price : prices){
            if (price < minPrice)
                minPrice = price;
            else if (price - minPrice > max_profit){
                max_profit = price - minPrice;
            }
        }

        return max_profit;
    }
}
