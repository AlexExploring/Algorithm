package JZOF.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *数组中重复的数字
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数
 * 字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组
 * 中任意一个重复的数字。
 *
 */
public class JZ3 {
    public static void main(String[] args) {
        int [] nums = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]){
                break;
            }
        }
        return nums[i];
    }


    /**
     * 时间复杂度和空间复杂度都为O(n)
     */
    public static int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
