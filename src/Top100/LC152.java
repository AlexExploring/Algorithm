package Top100;

/**
 * �˻����������
 */
public class LC152 {

    /**
     * ��̬�滮
     * f[i] ��ʾ��i��β������������˻�
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
