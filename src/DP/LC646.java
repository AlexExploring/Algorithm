package DP;

import java.util.Arrays;

/**
 * 最长数对链
 *
 * 题目：给出n个数对。在每一个数对中，第一个数字总是比第二个数字小。现在，我们定义一种跟随关系，
 * 当且仅当b < c时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。给定一个
 * 数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的
 * 一些数对来构造。
 */
public class LC646 {

    /**
     * 动态规划
     */
    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, (a, b) -> { return a[0] - b[0]; });
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    /**
     * 动态规划 优化 从后向前遍历
     */
    public int findLongestChain1(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, (a, b) -> { return a[0] - b[0]; });
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[len - 1];
    }

    /**
     * 贪心
     *
     * 思路：要挑选最长数对链的第一个数对时，最优的选择是挑选第二个数字最小的，这样能给挑选后续
     * 的数对留下更多的空间。挑完第一个数对后，要挑第二个数对时，也是按照相同的思路，是在剩下的
     * 数对中，第一个数字满足题意的条件下，挑选第二个数字最小的。按照这样的思路，可以先将输入按
     * 照第二个数字排序，然后不停地判断第一个数字是否能满足大于前一个数对的第二个数字即可。
     */
    public int findLongestChain2(int[][] pairs) {
        int curr = Integer.MIN_VALUE, res = 0;
        Arrays.sort(pairs, (a, b) -> { return a[1] - b[1]; });
        for (int[] p : pairs) {
            if (curr < p[0]) {
                curr = p[1];
                res++;
            }
        }
        return res;
    }
}