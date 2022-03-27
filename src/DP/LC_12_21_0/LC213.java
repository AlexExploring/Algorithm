package DP.LC_12_21_0;

/**
 * @author zhxspacex
 * @date 2020/12/16 17:39
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *打家劫舍2
 *相关问题 LC198 打家劫舍
 */
public class LC213 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        System.out.println(rob(a));
    }

    /**
     *分两种情况讨论，
     */
    public static int rob(int[] nums) {
        int len = nums.length;
        int tmax = 0;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0],nums[1]);

        int [] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len-1; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        tmax = dp[len-2];

        Arrays.fill(dp,0);
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1],nums[2]);
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return Math.max(tmax,dp[len-1]);
    }

    /**
     *简写
     *不用使用Arrays.fill(dp,0);将dp[]数组重置为全0数组，但必须先执行不抢第一个，否则dp[n-2]会被覆盖掉
     */
    public static int rob1(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0],nums[1]);

        int [] dp = new int[len];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1],nums[2]);
        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len-1; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return Math.max(dp[len-2],dp[len-1]);
    }
}
