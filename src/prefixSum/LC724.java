package prefixSum;

import java.util.Arrays;

/**
 * 寻找中心数组的下标
 */
public class LC724 {

    /**
     * 前缀和
     */
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int [] pre = new int[len+1];
        for (int i = 1; i <= len ; i++) {
            pre[i] = nums[i-1]+pre[i-1];
        }

        for (int i = 1; i <= len; i++) {
            if (pre[i-1] == pre[len]-pre[i]) {
                return i-1;
            }
        }

        return -1;
    }

    /**
     * 优化
     *
     * sum为当前元素左侧所有元素之和，如果i是中心索引，则一定满足：2 * sum + nums[i] == total
     */
    public int pivotIndex1(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
