package prefixSum;

import java.util.Arrays;

/**
 * 寻找中心数组的下标
 */
public class LC724 {

    /**
     * 前缀和
     */
    public int pivotIndex(int[] nums) {
        int [] sums = new int[nums.length+1];
        for (int i = 1; i < sums.length ; i++) {
            sums[i] = nums[i-1]+sums[i-1];
        }

        int len = sums.length;
        for (int i = 1; i < len; i++) {
            if (sums[i-1]==sums[len-1]-sums[i]) {
                return i-1;
            }
        }
        return -1;
    }

    public int pivotIndex1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * count + nums[i] == sum) {
                return i;
            }
            count += nums[i];
        }
        return -1;
    }
}
