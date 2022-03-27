package DP;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zhxspacex
 * @date 2020/12/14 20:09
 */
public class LC1 {
    public static void main(String[] args) {
        int [] nums = {2,7,5,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum2(nums,target)));
    }

    /**
     *方法一
     */
    public static int[] twoSum(int [] nums,int target){
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
     * 改进
     *          for (int i = 0; i < nums.length; i++) {
     *             for (int j = i+1; j < nums.length; j++) {
     *                 if (nums[i]+nums[j] == target){
     *                     return new int[]{i,j};
     *                 }
     *             }
     *         }
     */

    /**
     *方法二   和方法一类似，只是遍历方向不同
     */
    public static int[] twoSum1(int [] nums,int target){
        int [] a = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1;j > i; j--) {
                if (nums[i]+nums[j] == target){
                    a[0] = i;a[1] = j;
                    return a;
                }
            }
        }
        return null;
    }

    /**
     *方法三 使用HashMap
     */
    public static int[] twoSum2(int [] nums,int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target - nums[i],i);
        }
        return null;
    }



}
