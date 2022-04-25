package slidingWindow;

/**
 * �˻�С�� K ��������
 */
public class LC713 {

    /**
     * ��������
     */
    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        if (k <= 1) return 0;
        int count = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            count *= nums[right];
            //ע�⣺left++
            while (count >= k) count /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }
}
