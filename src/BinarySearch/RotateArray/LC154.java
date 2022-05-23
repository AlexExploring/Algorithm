package BinarySearch.RotateArray;

/**
 * 寻找旋转排序数组中的最小值 II （有重复数字）（相关题目LC153）
 */
public class LC154 {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high -= 1;//如果相等，不能确定nums[mid]究竟是在最小值的左侧还是右侧，
                //因此我们不能莽撞地忽略某一部分的元素。我们唯一可以知道的是，由于它们的
                // 值相同，所以无论 numbers[high]
                // 是不是最小值，都有一个它的「替代品」nums[mid],
                // 因此我们可以忽略二分查找区间的右端点。
            }
        }
        return nums[low];
    }
}
