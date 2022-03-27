package DP.LC_12_18_0_sz;

import java.util.Scanner;

public class LC53 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        System.out.println(maxSubArray(a));
    }

    /**
     *要求一个连续子数组的最大和，则该子数组不可能是从小于等于0的的项开始的
     */
    public static int maxSubArray(int [] nums){
        int len = nums.length;
        if (len == 0) return 0;
        int tmax = nums[0];

        int [] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i-1] <= 0){
                dp[i] = nums[i];
                tmax = Math.max(tmax, dp[i]);
            }else {
                dp[i] = (dp[i-1] + nums[i]);
                tmax = Math.max(tmax, dp[i]);
            }
        }
        return tmax;
    }

    /**
     * 简写
     */
    public static int maxSubArray1(int [] nums){
        int len = nums.length;
        if (len == 0) return 0;
        int tmax = nums[0];

        int [] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = (dp[i-1] <= 0) ? nums[i]:dp[i-1] + nums[i];
            tmax = Math.max(tmax, dp[i]);
        }
        return tmax;
    }

    /**
     *优化 ，空间复杂度为O(1)
     */
    public int maxSubArray2(int[] nums){
        int len = nums.length;
        if (len == 0) return 0;
        int tmax = nums[0];
        int cur = nums[0];
        for (int i = 1; i < len; i++) {
            cur = Math.max(nums[i],cur+nums[i]);
            tmax = Math.max(cur,tmax);
        }
        return tmax;
    }

    /**
     *简写
     * 假设sum<=0，那么后面的子序列肯定不包含目前的子序列，所以令sum = num；
     * 如果sum > 0对于后面的子序列是有好处的。res = Math.max(res, sum)保证可以找到最大的子序和。
     */
    public int maxSubArray3(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }

    /**
     *前一项加当前项的值大于当前项说名可能是最大和
     */
    public static int maxSubArray4(int [] nums){
        int len = nums.length;
        if (len == 0)
            return 0;
        int [] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < len; i++) {
            dp[i] = (dp[i-1]+nums[i] > nums[i]) ? dp[i-1]+nums[i]:nums[i];
            if (dp[i]>max)
                max = dp[i];
        }
        return max;
    }
}
