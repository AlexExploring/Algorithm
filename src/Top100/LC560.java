package Top100;

import java.util.HashMap;

/**
 * 和为k的子数组
 */

/**
 * 相似的题目
 *
 * 三数之和

 * 四数之和

 * 两数之和 II - 输入有序数组

 * 两数之和 III - 数据结构设计

 * 和为 K 的子数组

 * 两数之和 IV - 输入 BST

 * 小于 K 的两数之和
 */
public class LC560 {

    /**
     * 暴力
     */
    public int subarraySum(int[] nums, int k) {

        for (int i = 1; i < nums.length; i++) {
            nums[i]+=nums[i-1];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i!=0){
                    if ((nums[j]-nums[i-1])==k) ans++;
                }else {
                    if (nums[j]==k) ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 较方法一，更快一点
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            int sum = 0;
            // 区间里可能会有一些互相抵销的元素， 所以right一直遍历到数组尾部
            for (int right = left; right < len; right++) {
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 也是前缀和，速度叫方法一，快一点，空间复杂都为O(n)
     */
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 最优解
     *
     * https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
     */
    public int subarraySum3(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
