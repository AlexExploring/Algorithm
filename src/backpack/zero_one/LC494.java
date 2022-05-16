package backpack.zero_one;

/**
 * Ŀ���
 *
 * https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode-solution-o0cp/
 */
public class LC494 {

    int count = 0;

    /**
     * ����һ ���ݹ�
     */
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            //ֻ�� sum + nums[index] �� sum - nums[index]���ֿ���
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    /**
     * ����2��ת����0��1����
     * ��Ϊnums�е��������ڵ���0�������- �ŵ�Ԫ��֮��Ϊ neg����������� +
     * ��Ԫ��֮��Ϊ sum-neg���õ����ʽ(sum-neg)-neg=sum-2*neg=target��
     * �� neg = (sum - target)/2��
     *
     * dp[i][j] ��ʾ������nums ��ǰ i ������ѡȡԪ�أ�ʹ����ЩԪ��֮�͵��� j
     * �ķ�������
     *
     * ��LC518����
     */
    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // diff����Ϊ�Ǹ�����
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }

        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                //��ѡnum
                dp[i][j] = dp[i - 1][j];
                //ѡnum
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }

        return dp[n][neg];
    }

    /**
     * �ռ��Ż�
     */
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }

        int neg = diff / 2;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            //�ڲ�ѭ������õ�������ķ�ʽ�����ַ�ʽ��֤ת��������
            //dp[i-1][] �е�Ԫ��ֵ
            for (int j = neg; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
    }

}
