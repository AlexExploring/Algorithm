package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：两数之和 (数组是无序的，有重复数字)
 * 类似题目LC167：两数之和II
 */
public class LC1 {

    /**
     * 暴力
     */
    public int[] twoSum(int [] nums,int target){
        int [] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    a[0] = i;a[1] = j;
                    return a;
                }
            }
        }
        return null;
    }

    /**
     * 使用HashMap；
     * 由于是两数之和，知道一个数的值，就应该知道另一个数；
     */
    public int[] twoSum1(int [] nums,int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
