package BinarySearch.RotateArray;

/**
 *寻找旋转排序数组中的最小值I （无重复数字）(相关题目LC154)
 *
 * 相关题目
 * LC154 寻找旋转排序数组中的最小值II
 *
 * 题目的要求只是找到最小的值，并将其返回，并且该题没有重复的数字
 */
public class LC153 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        //本题的 left + 1 ，要么是更大的值（升序），要么突然
        // 降序，掉到了最小值。所以无论如何，最小值还是包括在寻
        // 找范围内的。而右侧区域，如果草率就 right - 1 的话
        // ，可能就会错过最小值了
        while (low < high) {
            int mid = low + (high - low) / 2;
            //见LC153.png， 此时，mid有可能就是最小值的位置
            if (nums[mid] < nums[high]) {
                high = mid;
                //见LC153I.png，此时，mid不可能是最小值的位置
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
        }

        return nums[low];
    }
}
