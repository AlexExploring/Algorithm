package BinarySearch.RotateArray;

/**
 * 搜索旋转排序数组II
 */
public class LC81 {

    /**
     *本题可能含有重复的数字
     */
    public boolean search(int[] nums, int target) {
        if (nums.length==0) return false;
        if (nums.length==1) return nums[0]==target;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //这种写法有时候会产生溢出，即low和high相加的值可能会溢出所以
            /**
             * int mid = left + (right - left)/2;
             * */
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                return true;
            }
            if (nums[left]==nums[mid]&&nums[mid]==nums[right]){
                left++;right--;
            }
            //mid左侧有序
            else if (nums[mid] >= nums[left]) {//arr[mid] >= arr[left]
                //target 如果位于中间元素的左侧
                if (nums[mid] > target && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            //mid右侧有序
            else {
                //target 如果位于中间元素的右侧
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
