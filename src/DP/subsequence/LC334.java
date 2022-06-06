package DP.subsequence;

/**
 * @author zhxspacex
 * @date 2020/12/22 23:04
 */

import java.util.Scanner;

/**
 * 递增的三元子序列
 */
public class LC334 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String c []  = s.split(" ");
        int [] a = new int[c.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.valueOf(c[i]);
        }
        System.out.println(increasingTriplet1(a));
    }

    /**
     *双指针
     */
    public static boolean increasingTriplet1(int[] nums) {
        int len = nums.length;
        if (len < 3) return false;
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            }
            else if (num > mid) {
                return true;
            }
        }
        return false;
    }

    /**
     * 见LC300
     *动态规划
     */
    public boolean increasingTriplet2(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] >= 3) return true;
        }
        return false;
    }

    /**
     *定义两个数组forward[i]和backward[i]，forward[i]从前向后遍历，保存
     * [0, i]之间最小元素值，backward[i]从后向前遍历，保存[i, size - 1]
     * 间最大元素值。然后从前向后遍历，如果找到一个数满足forward[i] < nums[i]
     * < backward[i]，则表示三元子序列存在。
     */
    public boolean increasingTriplet3(int[] nums){
        if (nums.length < 3) return false;
        int size = nums.length;
        int [] f = new int[nums.length];
        int [] b = new int[nums.length];
        for (int i = 1; i < size; ++i) {
            f[i] = Math.min(f[i - 1], nums[i]);
        }
        for (int i = size - 2; i >= 0; --i) {
            b[i] =Math.max(b[i + 1], nums[i]);
        }
        for (int i = 0; i < size; ++i) {
            if (f[i] < nums[i] && nums[i] < b[i]) return true;
        }
        return false;

    }
}
