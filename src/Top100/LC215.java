package Top100;

import java.util.Arrays;

public class LC215 {

    /**
     * ʹ��API
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
