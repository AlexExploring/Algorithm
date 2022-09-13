package DP.subsequence;

import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * 题目：给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 */
public class LC300 {

    /**
     * 定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度，
     * 注意 nums[i] 必须被选取
     */
    public static int max(int [] nums){
        int len = nums.length;
        if (len == 0) return 0;

        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int max = 1;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                // 计算dp[i]时，需要O(n)的时间遍历dp[0,i-1]的所有状态。
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 官方题解
     * 贪心加二分查找
     * 考虑一个简单的贪心，如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，因此我
     * 们希望每次在上升子序列最后加上的那个数尽可能的小
     *
     * 基于上面的贪心思路，我们维护一个数组 d[i] ，表示长度为 i 的最长上升子序列的末尾元素的最小
     * 值，用 len 记录目前最长上升子序列的长度，起始时 len 为 1，d[1] = nums[0]
     *
     * d[i]数组虽然不是最长升序子序列，但是 当找到更长的升序子序列时d[]长度会增加。 对d[]维护有两种情况：
     * 1. 当nums[i] > d[len]时，nums[i]插入到d[]尾部，数组d[]长度len+1(即找到更长的升序子序列); 2
     * . nums[i]替换d[0~len-1]区间内的某个元素，d[]长度不变
     *
     */
    public static int max1(int [] nums){
        int len = 1, n = nums.length;

        if (n == 0) {
            return 0;
        }

        int[] d = new int[n + 1];
        d[len] = nums[0];

        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 如果找不到说明所有的数都比 nums[i]
                int l = 1, r = len, pos = 0;
                // 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }

        return len;
    }
}
