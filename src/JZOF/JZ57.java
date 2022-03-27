package JZOF;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *和为s的两个数字
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 输入中会出现重复数字
 */
public class JZ57 {
    public static void main(String[] args) {
        int [] data = {16,16,18,24,30,32,48};
        System.out.println(Arrays.toString(twoSum3(data,48)));
    }

    /**
     * 暴力  必超时
     */
    public static int[] twoSum1(int[] nums, int target) {
        int [] ans = new int[2];
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target){
                    ans[0]=nums[i];
                    ans[1]=nums[j];
                    flag=true;
                    break;
                }
            }
            if (flag) break;
        }
        return ans;
    }


    /**
     *哈希
     *
     * 时间复杂度O(N^2)
     * 提交耗时80ms
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],target-nums[i]);
        }

        int a=0,b=0;
        for (int i = 0; i < nums.length; i++) {
            int t = map.get(nums[i]);
            if (t>0){
                if (map.containsKey(t)){
                    a=nums[i];b=t;
                    break;
                }
            }
        }
        int [] ans = {a,b};
        return ans;
    }


    /**
     *  使用set 时间复杂度O(n)
     *  提交耗时  50ms
     *  这里换成map 来优化时间复杂度是一样的
     */
    public static int[] twoSum3(int[] nums, int target) {
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
     *双指针
     * 提交 耗时2ms
     */
    public static int[] twoSum4(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int s = nums[i] + nums[j];
            if(s < target) i++;
            else if(s > target) j--;
            else return new int[] { nums[i], nums[j] };
        }
        return new int[0];
    }

    /**
     *二分查找
     */
    public static int[] twoSum5(int[] nums, int target) {
        return new int[0];
    }
}
