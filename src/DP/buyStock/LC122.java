package DP.buyStock;

/**
 *  买卖股票的最佳时机II (可多次买卖)
 */
public class LC122 {

    /**
     * 贪心，由于购买股票没有限制，因次整个问题等价于寻找x个不相交的区间(li ,ri]使得总和最大，
     * 则让每一个区间最大就行，
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 1;i < prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }
}