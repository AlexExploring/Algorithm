package backpack.complete;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 零钱兑换 相关题目 LC518 零钱兑换II
 */
public class LC322 {

    /**
     * 动态规划
     *
     * 定义F(i) 为组成金额 i 所需最少的硬币数量
     */
    public static int coinChange(int [] a,int amount){
        int max = amount + 1;
        int [] dp = new int[amount + 1];
        //必须要填充
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - a[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
