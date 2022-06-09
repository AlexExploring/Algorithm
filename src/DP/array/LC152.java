package DP.array;

/**
 * 乘积最大子数组
 */
public class LC152 {

    /**
     * 动态规划: f[i] 表示以i结尾的子数组的最大乘积
     *
     * 数据范围：
     * 1. 1 <= nums.length <= 2 * 104
     * 2. -10 <= nums[i] <= 10
     * 3. nums 的任何前缀或后缀的乘积都 保证是一个 32-位 整数
     *
     * 因为数组中有负数，所以需要同时保存最大值和最小值两种状态
     */
    public int maxProduct(int[] nums) {
        int ans = nums[0],max = nums[0],min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int maxTemp = Math.max(nums[i]*min, Math.max(nums[i]*max, nums[i]));
            int minTemp = Math.min(nums[i]*min, Math.min(nums[i]*max, nums[i]));
            ans = Math.max(ans, maxTemp);
            max = maxTemp;
            min = minTemp;
        }

        return ans;
    }
}
