package DP;

/**
 * 跳跃游戏
 */
public class LC55 {

    /**
     * 对于每一个可以到达的位置 x，它使得 x+1, x+2,?,x+nums[x] 这些连续的位置都可以到达。
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        //可以到达的最右侧的下标
        int rightMost = 0;

        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost,i+nums[i]);
                //从当前下标i可以到达最后一个下标
                if (rightMost >= n-1) {
                    return true;
                }
            }
        }

        return false;
    }
}
