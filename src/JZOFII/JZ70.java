package JZOFII;

/**
 * 排序数组中只出现一次的数字
 */
public class JZ70 {

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
     * 时间复杂度O(n/2)
     */
    public int singleNonDuplicate1(int[] nums) {
        int len = nums.length;
        if (len <= 1) return nums[0];

        for (int i = 1; i < nums.length; i+=2) {
            if (nums[i] != nums[i-1]) return nums[i-1];
        }

        return nums[len-1];
    }

    /**
     * 二分法
     * 时间复杂度O(log(n))
     */
    public int singleNonDuplicate2(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
