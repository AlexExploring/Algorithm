package DP.LC_12_21_0;

import java.util.Scanner;
/**
 *打家劫舍
 *相关问题 LC213 打家劫舍2
 */
public class LC198 {
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
     *状态：dp[i]
     * 状态转移方程
     */
    public static int rob(int [] nums){
        int len = nums.length;
        int max = 0;
        //对特殊值情况进行处理
        if (len == 1) return nums[0];
        if (len == 2) return Math.max(nums[0],nums[1]);

        //初始化
        int [] dp = new int[len];
        dp[0] = nums[0];
        max = dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = nums[i];
        }

        for (int i = 2; i < len; i++) {
            if (i-3>=0)//这种情况下dp[i-2]和dp[i-3]都满足不相邻的条件而且，当这两者中任意取一个之后，
                //dp[i-2]或dp[i-3] 到dp[i]中间也不能再取其他的值，
                dp[i]+=Math.max(dp[i-2],dp[i-3]);
            else
                dp[i]+=dp[i-2];
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }

    /**
     *官方题解
     * [1,2,3,1];
     * Si表示偷窃前i键房屋能获得的最大金额数，Hi表示第i间房屋藏有的最大金额。
     * S0 = H0 = 1；
     * S1 = max(S0,H1) = 2;
     * s2 = max(S1,S0+H2)) = 4;
     * S4 = max(S2,S1+H3) = 4;
     *
     * 偷或不偷第n间房两种方案讨论，偷第n间房则不能偷第n-1间房，，偷第n-1间房
     * 则不能偷第n间房，
     * Sn = max(S(n-1),S(n-2)+Hn）
     *
     */
    public static int rob1(int [] nums){
        int len = nums.length;
        //对特殊值情况进行处理
        if (len == 1) return nums[0];
        int [] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            //偷第n-1间则不能偷第n间，偷第n-2间则可以偷第n间
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[len-1];
    }

    /**
     *官方题解，将空间复杂度优化为O(1),
     * 因为dp[i]只依赖于dp[i-1]和dp[i-2]这两个状态
     */
    public static int rob2(int [] nums){
        int len = nums.length;
        //对特殊值情况进行处理
        if (len == 1) return nums[0];
        int first = nums[0];
        int second = Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            int temp = second;
            second = Math.max(second,first+nums[i]);
            first = temp;
        }
        return second;
    }
}
