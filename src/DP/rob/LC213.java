package DP.rob;

/**
 * 打家劫舍II
 * 相关问题 LC198 打家劫舍
 */
public class LC213 {

    /**
     * 简写
     * 不用使用Arrays.fill(dp,0);将dp[]数组重置为全0数组，但必须先执行不抢第一个，否则dp[n-2]会被覆盖掉
     */
    public static int rob1(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0],nums[1]);

        //不抢第一家
        int [] dp = new int[len];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1],nums[2]);
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        //不抢最后一家
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len-1; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        // dp[len-2] 不抢最后一家; dp[len-1] 不抢第一家
        return Math.max(dp[len-2],dp[len-1]);
    }

    /**
     * 官方题解
     */
    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0], nums[1]);

        //分别考虑不偷最后一家和不偷第一家
        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
