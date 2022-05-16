package backpack.zero_one;

/**
 * 目标和
 *
 * https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode-solution-o0cp/
 */
public class LC494 {

    int count = 0;

    /**
     * 方法一 ：递归
     */
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            //只有 sum + nums[index] 和 sum - nums[index]两种可能
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    /**
     * 方法2：转换成0，1背包
     * 因为nums中的数都大于等于0，记添加- 号的元素之和为 neg，则其余添加 +
     * 的元素之和为 sum-neg；得到表达式(sum-neg)-neg=sum-2*neg=target，
     * 即 neg = (sum - target)/2。
     *
     * dp[i][j] 表示在数组nums 的前 i 个数中选取元素，使得这些元素之和等于 j
     * 的方案数。
     *
     * 和LC518类似
     */
    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // diff必须为非负整数
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }

        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                //不选num
                dp[i][j] = dp[i - 1][j];
                //选num
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }

        return dp[n][neg];
    }

    /**
     * 空间优化
     */
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }

        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            //内层循环需采用倒序遍历的方式，这种方式保证转移来的是
            //dp[i-1][] 中的元素值
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }

}
