package BinarySearch;

/**
 *搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */
public class LC35 {
    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,0));
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0,r = nums.length-1;

        while (l<=r){
            int mid = l + (r - l)/2;
            if (target==nums[mid]){
                return mid;
            }
            if (target<nums[mid]){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return l;
    }
}
