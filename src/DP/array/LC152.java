package DP.array;

/**
 * �˻����������
 */
public class LC152 {

    /**
     * ��̬�滮: f[i] ��ʾ��i��β������������˻�
     *
     * ���ݷ�Χ��
     * 1. 1 <= nums.length <= 2 * 104
     * 2. -10 <= nums[i] <= 10
     * 3. nums ���κ�ǰ׺���׺�ĳ˻��� ��֤��һ�� 32-λ ����
     *
     * ��Ϊ�������и�����������Ҫͬʱ�������ֵ����Сֵ����״̬
     */
    public int maxProduct(int[] nums) {
        int ans = nums[0],max = nums[0],min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int maxTemp = Math.max(nums[i]*min, Math.max(nums[i]*max, nums[i]));
            int minTemp = Math.min(nums[i]*min, Math.min(nums[i]*max, nums[i]));
            ans = Math.max(ans, maxTemp);
            max = maxTemp;
            min = minTemp;
        }

        return ans;
    }
}
