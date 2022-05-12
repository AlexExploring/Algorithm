package DP.buyStock;

import java.util.Scanner;

/**
 * @author zhxspacex
 * @date 2020/12/16 22:40
 */

/**
 *买卖股票的最佳时机III
 */
public class LC123 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       String s = scan.nextLine();
       String c []  = s.split(" ");
       int [] a = new int[c.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(c[i]);
        }
        System.out.println(maxProfit(a));
    }

    /**
     *双向遍历，
     *
     * dp1[i] = max(dp[i-1], prices[i] - minval) 从前往后遍历，表示第1天到第i天之间的最大利润（通过是否在第i天卖出确认）；
     * dp2[i] = max(dp[i+1], maxval - prices[i]) 从后往前遍历，表示第i天到最后一天之间的最大利润（通过是否在第i天买进确认）；
     * res = max(dp1 + dp2)，(dp1 + dp2)[i] 正好表示从第1天到最后一天经过两次交易的最大利润，我们的目标是找到令总利润最大的i。
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int [] dp1 = new int[len];
        int [] dp2 = new int[len];
        int minval = prices[0];
        int maxval = prices[len-1];
        int tmax = 0,ans = 0;

        for (int i = 1; i < len; i++) {
            dp1[i] = Math.max(dp1[i-1],prices[i]-minval);
            minval = Math.min(minval,prices[i]);
        }

        for (int i = len-2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i+1],maxval-prices[i]);
            maxval = Math.max(maxval,prices[i]);
        }

        for (int i = 0; i < len; i++) {
            tmax = dp1[i]+dp2[i];
            ans = Math.max(tmax,ans);
        }
        return ans;
    }

    public int maxProfit1(int[] prices) {
        return f(prices, 0, 0, 0);
    }

    /**
     *
     * @param prices
     * @param i 当前考虑第几天
     * @param hasStock 是否有股票在手
     * @param counts 已经交易的次数（每买一次股票就加一）
     * @return
     */
    private int f(int[] prices, int i, int hasStock, int counts) {
        // 如果已经买了两次股票，并且手里已经没有股票了，那么后面的天数不需要考虑
        if(i >= prices.length || (counts >= 2 && hasStock < 1))
            return 0;
        // 如果手里有股票，我可以选择卖或者不卖
        if(hasStock > 0)
            return  Math.max(prices[i] + f(prices, i+1, 0, counts),
                    f(prices, i+1, 1, counts));
        // 如果没有股票，我可以选择买或者不买
        else
            return Math.max(-prices[i] + f(prices, i+1, 1, counts+1),
                f(prices, i+1, 0, counts));
    }

}

