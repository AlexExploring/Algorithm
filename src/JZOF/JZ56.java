package JZOF;

import java.util.*;

/**
 *数组中数字出现的次数
 *
 *
 * 两个相同的数的异或结果为0
 *
 * 任何数和0进行异或值都为它本身
 */
public class JZ56 {
    public static void main(String[] args) {
        System.out.println(0^234);
    }

    /**
     *暴力
     */
    public static int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) map.put(nums[i],2);
            else map.put(nums[i],1);
        }

        int [] res = new int[2];
        int index = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key)==1) res[index++] = key;
        }
        return res;
    }

    /**
     *优化1
     */
    public static int[] singleNumbers1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) set.remove(nums[i]);
            else set.add(nums[i]);
        }

        int [] res = new int[2];
        int index = 0;
        for (Integer s : set) {
            res[index++] = s;
        }
        return res;
    }

    /**
     *异或运算
     */
    public static int[] singleNumbers2(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
