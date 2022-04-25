package slidingWindow;

/**
 * 乘积小于 K 的子数组
 */
public class LC713 {

    /**
     * 滑动窗口
     */
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            count *= nums[right];
            //注意：left++
            while (count >= k) count /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
