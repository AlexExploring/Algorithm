package DP.array;

/**
 * 戳气球
 */
public class LC312 {

    public static void main(String[] args) {
        int [] nums = new int[]{3,1,5,8};
        System.out.println(new LC312().maxCoins(nums));
    }

    /**
     * dp[i][j]: 表示戳破开区间(i,j)内的气球，可以获得的最大金币数
     *
     * 题解：https://leetcode.cn/problems/burst-balloons/solution/zhe-ge-cai-pu-zi-ji-zai-jia-ye-neng-zuo-guan-jian-/
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        //为了避免越界，降低代码编写难度，使用val来存储nums中的数，并进行预处理
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }

        //枚举左开区间
        for (int i = n - 1; i >= 0; i--) {
            //枚举右开区间
            for (int j = i + 2; j <= n + 1; j++) {
                //区间内的任意一个气球都有可能最后一个被戳爆
                for (int k = i + 1; k < j; k++) {
                    //戳破当前气球获得的金币
                    int sum = val[i] * val[k] * val[j];
                    //由于假设当前戳破的k是当前区间的最后一个气球，所以当前气球的两边必然已
                    // 经被戳破，且值已经计算出来了
                    sum += rec[i][k] + rec[k][j];
                    //保证rec[i][j],是戳破的当前开区间内所有气球能获得的最大金币数
                    rec[i][j] = Math.max(rec[i][j], sum);
                    for (int[] ints : rec) {
                        for (int anInt : ints) {
                        }
                    }
                }
            }
        }

        return rec[0][n + 1];
    }
}
