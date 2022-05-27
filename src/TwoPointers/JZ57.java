package TwoPointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *和为s的两个数字
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 输入中会出现重复数字
 *
 * 和LC1类似，只是LC1 的nums不是有序的
 */
public class JZ57 {

    /**
     * 方法一：哈希表
     * 题目要求：1 <= nums[i] <= 10^6
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{nums[map.get(target-nums[i])],nums[i]};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }


    /**
     *  使用set 时间复杂度O(n)
     *
     *  和twoSum()的耗时差不多
     */
    public int[] twoSum1(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int [] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target-nums[i])){
                ans[0] = target-nums[i];
                ans[1] = nums[i];
                break;
            }
            set.add(nums[i]);
        }
        return ans;
    }

    /**
     * 双指针
     * 提交 耗时2ms
     */
    public int[] twoSum2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while(i < j) {
            int t = nums[i] + nums[j];
            if(t < target) i++;
            else if(t > target) j--;
            else return new int[] { nums[i], nums[j] };
        }

        return new int[0];
    }
}
