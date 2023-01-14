package TwoPointers;

import java.util.HashSet;
import java.util.Set;

/**
 * title：和为s的两个数字
 *
 * 题目：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和
 * 正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class JZ57I {

    /**
     * 方法一：双指针
     * 时间复杂度O(n),空间复杂度O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        int l = 0,r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) r--;
            else if (sum < target) l++;
            else return new int[]{nums[l],nums[r]};
        }

        return new int[0];
    }

    /**
     * 方法二：使用set
     * 时间复杂度O(n),空间复杂度O(n)
     */
    public int[] twoSum1(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{target - num,num};
            }
            set.add(num);
        }

        return new int[0];
    }
}
