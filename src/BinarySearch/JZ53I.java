package BinarySearch;

/**
 * 在排序数组中查找目标数字（返回要查找的数字出现的次数）
 *
 * 和LC34相同，。只是返回值不一样
 */
public class JZ53I {

    /**
     * 暴力
     */
    public int search(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) res++;
        }
        return res;
    }

    /**
     * 二分查找先找到一个目标数字，再向两边扩展
     */
    public int search1(int[] nums, int target) {
        if (nums.length == 0) return 0;

        int low = 0, high = nums.length - 1, mid = 0, flag = 0;

        while (low <= high) {
            mid = (high - low) / 2 + low;
            if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] > target) high = mid - 1;
            else if (nums[mid] == target) {
                flag = 1;
                break;
            }
        }

        //从mid处向两边扩展，i向左，j向右
        int i = mid, j = mid + 1, res = 0;
        if (flag == 1) {
            while (i >= 0 && nums[i] == target) {
                i--;
                res++;
            }
            while (j <= nums.length - 1 && nums[j] == target) {
                j++;
                res++;
            }
        } else return 0;

        return res;
    }

    /**
     * 找到包含所有目标数字的一个左边界，一直向右扩展，直到没有目标数字
     */
    public int search2(int[] nums, int target) {
        int len = nums.length;

        //查找nums第一个不小于目标值的数的下标，左边界
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        int left = l;
        //如果左边界 >= len,说明nums中没有target，直接返回0
        if (left >= len) return 0;

        //查找nums中第一个大于目标值的数的下标，右边界
        l = 0;
        r = len - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        //此时l指向的就是右边界
        return l - left;
    }

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        System.out.println(new JZ53I().search3(nums, 8));
    }

    /**
     * 优化search2
     */
    public int search3(int[] nums, int target) {
        return helper(nums,target) - helper(nums,target-1);
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
