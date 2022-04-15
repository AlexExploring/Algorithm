package JZOFII;

/**
 * 排列的数目 （和LC377相同：组合总和IV）
 *
 * 和LC518零钱兑换II类似(该题不需要考虑顺序)
 */
public class JZ104 {

    /**
     * 注意：顺序不同的序列被视作不同的组合
     *
     * 定义dp[x] 表示选取的元素之和等于 x 的方案数，目标是求dp[target]
     *
     * 注意:做法是否考虑到选取元素的顺序？答案是肯定的。因为外层循环是遍历从
     * 1 到 target 的值，内层循环是遍历数组 nums 的值，在计算dp[i] 的值时，
     * nums 中的每个小于等于 i 的元素都可能作为元素之和等于 i 的排列的最后一
     * 个元素。例如，1 和 3 都在数组nums 中，计算dp[4] 的时候，排列的最后一
     * 个元素可以是 1 也可以是 3，因此dp[1] 和dp[3] 都会被考虑到，即不同的顺
     * 序都会被考虑到。
     */
    public int combinationSum4(int[] nums, int target) {
        int [] dp = new int[target+1];
        //只有当不选取任何元素时，元素之和才为 0，因此只有 1 种方案
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
