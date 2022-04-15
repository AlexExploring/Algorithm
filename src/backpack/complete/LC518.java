package backpack.complete;

/**
 * 零钱兑换II （和JZ104类似）
 *
 * 题解链接：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-ii-by-leetcode-soluti-f7uh/
 */
public class LC518 {

    /**
     *  定义dp[x] 表示金额之和等于 xx 的硬币组合数，目标是求dp[amount]
     *
     *  注意：做法不会重复计算不同的排列。因为外层循环是遍历数组coins 的值，
     *  内层循环是遍历不同的金额之和，在计算 dp[i] 的值时，可以确保金额之和
     *  等于 i的硬币面额的顺序，由于顺序确定，因此不会重复计算不同的排列。
     *  例子见图片
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
