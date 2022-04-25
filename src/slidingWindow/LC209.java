package slidingWindow;

import java.util.Arrays;

/**
 * 和大于等于target的最短子数字
 */
public class LC209 {


    /**
     * 暴力法
     */
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len==0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum+=nums[j];
                if (sum>=target) {
                    ans = Math.min(ans,j-i+1);
                    break;
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 前缀和+二分查找
     *
     *  时间复杂度为O(log(n))
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int len = nums.length;
        if (len==0) return 0;
        int ans = Integer.MAX_VALUE;

        // 为了方便计算，令 size = n + 1
        // sums[i] = total 意味着前 i个元素的前缀和为 total
        int [] sums = new int[len+1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i-1]+nums[i-1];
        }

        //sums[j]-sums[i] >= target
        for (int i = 1; i <= len; i++) {
            // 因为i是包括在间距内的，所以需要target+sums[i-1]
            int ser = target+sums[i-1];
            //从下标i开始，sums[bound]>=ser ，
            int bound = Arrays.binarySearch(sums,ser);
            if (bound==-1) bound = 0;
            if (bound<=len) ans = Math.min(ans,(bound-(i-1)));
        }

        return ans==Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 方法三： 滑动窗口
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        if (len==0) return 0;
        int ans = Integer.MAX_VALUE;

        int start = 0,end = 0;
        int sum = 0;
        while (end<len) {
            sum+=nums[end];
            //值要sum >= target 就需要循环更新ans
            while (sum>=target) {
                ans = Math.min(ans,end-start+1);
                sum-=nums[start];
                start++;
            }
            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}