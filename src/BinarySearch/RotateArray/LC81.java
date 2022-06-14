package BinarySearch.RotateArray;

/**
 * 搜索旋转排序数组II
 */
public class LC81 {

    /**
     * 本题可能含有重复的数字
     *
     * 对于数组中有重复元素的情况，二分查找时可能会有 a[l]=a[mid]=a[r]，此时无法判断区间[l,mid]
     * 和区间 [mid+1,r] 哪个是有序的。
     *
     * 例如 nums=[3,1,2,3,3,3,3]，target=2，首次二分时无法判断区间 [0,3] 和区间 [4,6] 哪个是
     * 有序的对于这种情况，我们只能将当前二分区间的左边界加一，右边界减一，然后在新区间上继续二分查找。
     */
    public boolean search(int[] nums, int target) {
        if (nums.length==0) return false;
        if (nums.length==1) return nums[0]==target;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (target == nums[mid]) {
                return true;
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]){
                left++;right--;
            } else if (nums[mid] >= nums[left]) {//mid左侧有序
                //target 如果位于中间元素的左侧
                if (nums[mid] > target && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else { //mid右侧有序
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
