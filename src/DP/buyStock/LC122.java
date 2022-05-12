package DP.buyStock;

/**
 * @author zhxspacex
 * @date 2020/12/16 21:41
 */

import java.util.Scanner;

/**
 *买卖股票的最佳时机II
 */
public class LC122 {
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
     *动态规划
     */
    public static int maxProfit(int[] prices){
        if (prices.length <= 1) return 0;

        int minprice = prices[0];
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minprice || prices[i] < prices[i-1]){
                minprice = prices[i];
            }
            else
                sum += prices[i]-prices[i-1];
        }
        return sum;
    }

    /**
     *参考
     *
     * 贪心，由于购买股票没有限制，因次整个问题等价于寻找x个不相交的区间(li ,ri]使得总和最大，
     * 则让每一个区间最大就行，
     */
    public int maxProfit1(int[] prices) {
        int ans=0;
        for(int i=1;i<=prices.length-1;i++)
        {
            if(prices[i]>prices[i-1])
            {
                ans+=prices[i]-prices[i-1];
            }
        }
        return ans;
    }
}
