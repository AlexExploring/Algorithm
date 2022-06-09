package DP.buyStock;

/**
 * 买卖股票的最佳时机I
 */
public class LC121 {

    /**
     * 动态规划：注意只能买卖一次
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
                max_profit = price-minPrice;
            }
        }

        return max_profit;
    }
}
