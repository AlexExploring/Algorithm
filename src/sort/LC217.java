package sort;

import java.util.Arrays;

/**
 * 存在重复元素
 */
public class LC217 {

    /**
     * 方法一：排序
     */
    public boolean containsDuplicate(int[] nums) {

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] ==nums[i-1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * 方法二：hash
     */
}
