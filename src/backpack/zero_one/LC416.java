package backpack.zero_one;

/**
 * �ָ�Ⱥ��Ӽ�
 */
public class LC416 {

    /**
     * ת��Ϊ��������
     *
     * ������ά���� dp������ n �� target+1 �У�
     * ���� dp[i][j] ��ʾ������� [0,i] �±귶Χ��ѡȡ
     * ���ɸ��������������� 0 �������Ƿ����һ��ѡȡ����ʹ�ñ�ѡȡ���������ĺ͵���
     * j����ʼʱ��dp �е�ȫ��Ԫ�ض��� false��
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
        // sumΪż��ʱ,��������ں͵�1/2,�������Ȼ�����ܻ���Ϊ�Ⱥ͵�������
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        // dp�����ʼ��
        boolean[][] dp = new boolean[n][target + 1];
        //dp[i][0] ��û��ѡ���κ���
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // �� i==0ʱ��ֻ��һ�������� nums[0] ���Ա�ѡȡ����� dp[0][nums[0]]=true
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    //��ѡ�ɲ�ѡ
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                } else {
                    //ֻ�ܲ�ѡ
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }

    /**
     * �ռ临�Ӷ��Ż�
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
            // �Ż��ռ����Ҫ�Ӵ��С���㣬��ֹ��� ������
            for (int j = target; j >= num; --j) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
}
