package JZOF.binarySearch;

/**
 *在排序数组中查找目标数字
 */
public class JZ53I {
    public static void main(String[] args) {
        int [] nums = {1};
        System.out.println(search1(nums,1));
    }

    /**
     *暴力
     */
    public int search(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target==nums[i]) res++;
        }
        return res;
    }

    /**
     *先找到一个目标数字，再向两边扩展
     */
    public static int search1(int[] nums, int target) {
        if (nums.length==0) return 0;
        int low = 0,high = nums.length-1,mid = 0,flag = 0;
        while (low<=high){
            mid = (low+high)/2;
            if (nums[mid]<target) low = mid+1;
            else if (nums[mid]>target) high = mid-1;
            else if (nums[mid]==target) {
                flag=1;break;
            }
        }

        int i = mid,j = mid+1,res = 0;
        if (flag==1){
            while (i>=0&&nums[i]==target) {
                i--;res++;
            }
            while (j<=nums.length-1&&nums[j]==target){
                j++;res++;
            }
        }else return 0;

        return res;
    }

    /**
     * 找到包含所有目标数字的一个左边界，一直向右扩展，直到没有目标数字
     */
    public static int search2(int[] nums, int target) {
        int left =0,right = nums.length-1;
        int count = 0;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[mid]>=target)
                right=mid;
            if(nums[mid]<target)
                left = mid+1;
        }
        while(left<nums.length&&nums[left++]==target)
            count++;
        return count;
    }

    /**
     *优化到这里，对极端情况，如果nums中的target的数量接近nums的长度，在计算count的过程的时间复杂度就是O(N)
     *
     * 继续优化
     */

    /**
     *两侧二分搜索 分别确定左右边界  左右边界在目标的左右两侧
     */
    public static int search3(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        int right = i;   //下标i最终指向最右侧target的右一位
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 left  只需要保证二分区间的右边界j位于最左侧target的左一位
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;   //下标j最终指向最左侧target的的左一位
        return right - left - 1;
    }

    /**
     *优化search3
     */
    public int search4(int[] nums, int target) {
        //arget-1 代表着去查找比 target 小的首个数字的右边界~ 至于这个数字具体小多少，都是能查找到的
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
