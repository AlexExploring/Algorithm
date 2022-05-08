package slidingWindow;

import java.math.BigInteger;
import java.util.TreeSet;

/**
 * 值和下标之差都在给定的范围内
 */
public class LC220 {

    /**
     * 方法一:使用BigInteger避免减法超出范围导致溢出，
     * 时间复杂度为 O(n) ，超时
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        BigInteger T = BigInteger.valueOf(t);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int compValAns = BigInteger.valueOf(nums[i]).subtract(BigInteger.valueOf(nums[j])).abs().compareTo(T);
                // 下标之差
                int compIndAns = Math.abs(i-j);
                if (compValAns <= 0 && compIndAns <= k) return true;
            }
        }
        return false;
    }

    /**
     * 方法二：滑动窗口 + 有序集合
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            // set.ceiling(): Returns the least element in this set greater
            // than or equal to the given element, or {@code null} if there
            // is no such element.
            // 我们检查窗口中是否存在元素落在区间 [nums[i] - t, nums[i] + t] 中即可。
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            // 因为下标是从0开始，所以 i >= k, 维护一个大小为k的滑动窗口
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
