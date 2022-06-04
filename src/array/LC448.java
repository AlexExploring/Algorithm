package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 */
public class LC448 {

    /**
     * 题目要求不适用额外空间，且时间复杂度为O(n),则只能原地修改
     * <p>
     * 数据范围：
     * n == nums.length
     * 1 <= n <= 105
     * 1 <= nums[i] <= n
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) ans.add(i + 1);
        }

        return ans;
    }
}
