package BinarySearch;


import java.util.Arrays;

/**
 *在排序数组中查找元素的第一个和最后一个位置
 */
public class LC34 {
    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums,8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int l = 0,r = nums.length-1,begin = -1,end = -1;
        while (l<=r){
            int mid = l+(r-l)/2;
            if (target==nums[mid]){
                begin = end = mid;break;
            }

            if (target<nums[mid])
                r = mid-1;
            else l = mid+1;
        }

        if (begin==-1){
            int [] ans = {-1,-1}; return ans;
        }else {
            while (true)
                if ((begin-1>=0)&&nums[begin-1]==target)
                    begin--;
                else break;
            while (true)
                if ((end+1<=nums.length-1)&&nums[end+1]==target)
                    end++;
                else break;
            int [] ans = {begin,end};return ans;
        }
    }
}
