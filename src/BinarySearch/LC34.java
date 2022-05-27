package BinarySearch;

/**
 * 在排序数组中查找目标 元素的第一个和最后一个位置（左右边界）
 *
 * 和JZ53I相同，只是返回值不一样
 */
public class LC34 {

    public int[] searchRange(int[] nums, int target) {
        int left = helper(nums,target-1);
        int right = helper(nums,target)-1;
        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return new int[]{left,right};
        }
        return new int[]{-1,-1};
    }

    /**
     * 查找nums中第一个大于目标值的数的下标
     */
    public int helper(int [] nums,int target) {
        int l = 0,r = nums.length-1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (nums[mid] <= target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
}
