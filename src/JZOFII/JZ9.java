package JZOFII;

/**
 * 乘积小于k的子数组
 */
public class JZ9 {

    /**
     * 暴力
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0,len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 1;
            for (int j = i; j < len; j++) {
                sum *= nums[j];
                if (sum<k) ans++;
                else break;
            }
        }
        return ans;
    }

    /**
     * 滑动窗口
     */
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        int left = 0,ans = 0,sum = 1,len = nums.length;

        for (int right = 0; right < len; right++) {
            sum *= nums[right];
            while (left <= right && sum >= k) {
                sum /= nums[left++];
            }
            if (left <= right) {
                ans += right - left + 1;
            }
        }

        return ans;
    }

}
