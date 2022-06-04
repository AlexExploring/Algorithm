package DP.rob;

/**
 *打家劫舍I
 *相关问题 LC213 打家劫舍II
 */
public class LC198 {

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
    public static int rob(int [] nums){
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
     * 官方题解，将空间复杂度优化为O(1),
     * 因为dp[i]只依赖于dp[i-1]和dp[i-2]这两个状态
     */
    public static int rob1(int [] nums){
        int len = nums.length;
        //对特殊值情况进行处理
        if (len == 1) return nums[0];

        // 递推计算过程中只需要记录两个状态
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
