package DP.buyStock;

import java.util.Scanner;

/**
 * @author zhxspacex
 * @date 2020/12/16 20:58
 */
/**
 *买股票系列
 */
/**
 *买卖股票的最佳时机
 */
public class LC121 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        System.out.println(maxProfit(a));
    }

    /**
     *暴力解法
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int max = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (prices[j] > prices[i]){
                    max = Math.max(max,prices[j]-prices[i]);
                }
            }
        }
        return max;
    }

    /**
     *动态规划
     * minprice  maxprice
     */
    public static int maxProfit1(int[] prices){
        int len = prices.length;
        if (len <= 1) return 0;

        int minprice = Integer.MAX_VALUE;
        int max_profit = 0;
        for(int price:prices){
            if (price < minprice)
                minprice = price;
            else if (price-minprice > max_profit){
                max_profit = price-minprice;
            }
        }
        return max_profit;
    }


}
