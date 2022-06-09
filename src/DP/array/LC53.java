package DP.array;


/**
 * 最大子数组和
 */
public class LC53 {

    /**
     * 动态规划：dp[i]：表示以 nums[i] 结尾 的 连续 子数组的最大和。
     *
     * 要求一个连续子数组的最大和，则该子数组不可能是从小于等于0的的项开始的
     */
    public static int maxSubArray(int [] nums){
        int len = nums.length;
        if (len == 0) return 0;

        int ans = nums[0];
        int [] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i] = (dp[i-1] <= 0) ? nums[i] : dp[i-1] + nums[i];
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    /**
     * 优化 ，空间复杂度为O(1)
     */
    public int maxSubArray1(int[] nums){
        int len = nums.length;
        if (len == 0) return 0;

        int ans = nums[0],pre = nums[0];

        for (int i = 1; i < len; i++) {
            pre = Math.max(nums[i],pre+nums[i]);
            ans = Math.max(pre,ans);
        }

        return ans;
    }

    /**
     * 递推
     *
     * 假设sum<=0，那么后面的子序列肯定不包含目前的子序列，所以令sum = num；
     * 如果sum > 0对于后面的子序列是有好处的。res = Math.max(res, sum)保证可以找到最大的子序和。
     */
    public int maxSubArray3(int[] nums) {
        int ans = nums[0],sum = 0;

        for (int num : nums) {
            if (sum > 0) sum += num;
            else sum = num;
            ans = Math.max(ans, sum);
        }

        return ans;
    }

}
