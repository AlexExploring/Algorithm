package prefixSum;

import java.util.HashMap;

/**
 * 和为k的子数组
 *
 * 数据范围：
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class LC560 {

    /**
     * 暴力
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            // 区间里可能会有一些互相抵销的元素， 所以right一直遍历到数组尾部
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和
     */
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组, pre[i]为前i个数的和
        int [] pre = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }

        int count = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                // 区间和 [i..j]，注意下标偏移
                if (pre[j] - pre[i-1] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和+哈希表优化
     *
     * map中，键是前缀和，值是对应前缀和出现的次数
     *
     * 「[i..j] 这个子数组和为 k 」这个条件我们可以转化为:pre[j]-pre[i-1]==k
     * 简单移项可得符合条件的下标i满足 pre[i-1] == pre[j]-k.
     * 所以我们考虑以 j 结尾的和为 k 的连续子数组个数时只要统计有多少个前缀和为
     * pre[j]-k 的 pre[i] 即可。
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        //对于下表为0的元素，前缀和为0，个数为1
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}