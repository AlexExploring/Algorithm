package JZOFII;

import java.util.Arrays;

/**
 *  左右两边子数组的和相等
 */
public class JZ12 {
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
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
