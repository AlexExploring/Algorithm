package JZOF.DP;

/**
 *连续子数组的最大和
 *
 * 一定是从一个非负数开始
 */
public class JZ42 {
    public static void main(String[] args) {
        int [] data = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(data));
    }

    /**
     *dp[j] 表示以元素nums[j]结尾的连续子数组的最大和
     */
    public static int maxSubArray1(int[] nums) {
        int [] dp = new int[nums.length+1];

        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for (int j = 1; j < nums.length; j++) {
            dp[j] = Math.max(nums[j],dp[j-1]+nums[j]);
            max = Math.max(dp[j],max);
        }

        return max;
    }

    /**
     *优化空间复杂度为 o(1)
     * 改变了原数组
     */
    public static int maxSubArray2(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);

            System.out.print(nums[i]+" ");
        }
        return res;
    }

    /**
     *优化空间复杂度为 O(1)
     * 不改变原数组
     *
     * 因为程序运行过程中只是用到了dp[j]和dp[j-1]
     */
    public static int maxSubArray3(int[] nums) {
        int max = nums[0];
        int former = 0,cur = nums[0];
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i];
            if (former>0) cur+=former;
            if (cur>max) max = cur;
            former = cur;
        }
        return max;
    }
}
