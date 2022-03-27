package Top100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC287 {

    /**
     * 使用set集合
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                ans = nums[i];break;
            }
        }
        return ans;
    }

    /**
     * 排序  该方法效率最低
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }


}
