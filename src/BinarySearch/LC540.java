package BinarySearch;

/**
 * 排序数组中只出现一次的数字
 */
public class LC540 {

    /**
     * 位运算
     * 时间复杂度O(n),
     */
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }


    /**
     * 题目要求只有一个数出现一次，其他数都出现两次
     * 时间复杂度O(n/2)
     */
    public int singleNonDuplicate1(int[] nums) {
        int len = nums.length;
        if (len <= 1) return nums[0];

        for (int i = 1; i < nums.length; i+=2) {
            if (nums[i] != nums[i-1]) return nums[i-1];
        }

        // 说明最后一个数出现了一次
        return nums[len-1];
    }

    /**
     * 思路：二分法。
     * 由于数组是有序的，因此数组中相同的元素一定相邻。对于下标 x 左边的下标 y，如果
     * nums[y]=nums[y+1]，则 y 一定是偶数；对于下标 x 右边的下标 z，如果
     * [z + 1]nums[z]=nums[z+1]，则 z 一定是奇数。只出现一次的数字的下标x，
     * 是相同元素开始下标的奇偶性分界，因此使二分查找的方法寻找下标x。
     *
     * 注意：1.当 mid 是偶数时，mid+1=mid?1；2.当 mid 是奇数时，mid?1=mid?1。
     *
     * 如果mid是偶数（奇数）的话，并且nums[mid] ！= nums[mid+1]（nums[mid] != nums[mid-1]） ,
     * 说明x肯定不在mid的右侧，所以r=mid
     *
     * 时间复杂度O(log(n))
     */
    public int singleNonDuplicate2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == nums[mid ^ 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
