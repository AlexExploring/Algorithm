package backpack.zero_one;

/**
 * 分割等和子集
 */
public class LC416 {

    /**
     * 转化为背包问题
     *
     * 创建二维数组 dp，包含 n 行 target+1 列，
     * 其中 dp[i][j] 表示从数组的 [0,i] 下标范围内选取
     * 若干个正整数（可以是 0 个），是否存在一种选取方案使得被选取的正整数的和等于
     * j。初始时，dp 中的全部元素都是 false。
     *
     */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        // sum为偶数时,最大数大于和的1/2,则数组必然不可能划分为等和的两部分
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        // dp数组初始化
        boolean[][] dp = new boolean[n][target + 1];
        //dp[i][0] 还没有选择任何数
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // 当 i==0时，只有一个正整数 nums[0] 可以被选取，因此 dp[0][nums[0]]=true
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    //可选可不选
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                } else {
                    //只能不选
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    /**
     * 空间复杂度优化
     */
    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // 优化空间后，需要从大大小计算，防止结果 被覆盖
            for (int j = target; j >= num; --j) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}
