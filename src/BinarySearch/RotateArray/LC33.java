package BinarySearch.RotateArray;

/**
 * 搜索旋转排序数组I
 * LC81 搜索旋转排序数组II
 * LC153寻找旋转排序数组中的最小值I,
 * LC154寻找旋转排序数组中的最小值II
 */
public class LC33 {

    /**
     * 整数数组 nums 按升序排列，数组中的值互不相同 。
     */
    public static int search(int[] nums, int target) {
        int left = 0,right = nums.length-1;

        while(left <= right){
            //这种写法有时候会产生溢出，即low和high相加的值可能会溢出所以
            int mid = left + (right - left)/2;

            if(target == nums[mid]) {
                return mid;
            }

            //mid左侧有序
            if(nums[mid] >= nums[left]) {
                //target 如果位于中间元素的左侧
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else { //位于右侧
                    left = mid + 1;
                }
            } else { //mid右侧有序
                //target 如果位于中间元素的右侧
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
