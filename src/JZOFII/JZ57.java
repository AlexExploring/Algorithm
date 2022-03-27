package JZOFII;

import java.math.BigInteger;
import java.util.TreeSet;

/**
 * 值和下标之差都在给定的范围内
 */
public class JZ57 {

    /**
     * 使用BigInteger避免减法超出范围导致溢出，超时
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        BigInteger T = BigInteger.valueOf(t);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i!=j) {
                    int compValAns = BigInteger.valueOf(nums[i]).subtract(BigInteger.valueOf(nums[j])).abs().compareTo(T);
                    int compIndAns = Math.abs(i-j);
                    if (compValAns <= 0 && compIndAns <= k) return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
