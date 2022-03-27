package JZOF.DP;

/**
 *���������������
 *
 * һ���Ǵ�һ���Ǹ�����ʼ
 */
public class JZ42 {
    public static void main(String[] args) {
        int [] data = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(data));
    }

    /**
     *dp[j] ��ʾ��Ԫ��nums[j]��β�����������������
     */
    public static int maxSubArray1(int[] nums) {
        int [] dp = new int[nums.length+1];

        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for (int j = 1; j < nums.length; j++) {
            dp[j] = Math.max(nums[j],dp[j-1]+nums[j]);
            max = Math.max(dp[j],max);
        }

        return max;
    }

    /**
     *�Ż��ռ临�Ӷ�Ϊ o(1)
     * �ı���ԭ����
     */
    public static int maxSubArray2(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);

            System.out.print(nums[i]+" ");
        }
        return res;
    }

    /**
     *�Ż��ռ临�Ӷ�Ϊ O(1)
     * ���ı�ԭ����
     *
     * ��Ϊ�������й�����ֻ���õ���dp[j]��dp[j-1]
     */
    public static int maxSubArray3(int[] nums) {
        int max = nums[0];
        int former = 0,cur = nums[0];
        for (int i = 0; i < nums.length; i++) {
            cur = nums[i];
            if (former>0) cur+=former;
            if (cur>max) max = cur;
            former = cur;
        }
        return max;
    }
}
