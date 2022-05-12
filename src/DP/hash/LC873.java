package DP.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长斐波那契数列 （和LC873相同）
 */
public class LC873 {

    /**
     * 使用set的暴力法
     */
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int el : arr) {
            set.add(el);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                //每次循环选择两个数开始寻找斐波那契数列
                int x = arr[j],y = arr[i]+arr[j];
                int length = 2;
                while (set.contains(y)) {
                    int temp = y;
                    y += x;
                    x = temp;
                    ans = Math.max(ans,++length);
                }
            }
        }

        return ans >= 3 ? ans : 0;
    }

    /**
     * 动态规划
     */
}
