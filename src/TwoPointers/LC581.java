package TwoPointers;

/**
 * �����������������
 *
 * ��Ŀ������һ���������� nums ������Ҫ�ҳ�һ�� ���������� ����������������
 * ��������������ô�������鶼���Ϊ��������
 *
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leet-yhlf/
 */
public class LC581 {

    public static void main(String[] args) {
        int [] nums = new int[]{2,6,8,10,9,15};
        System.out.println(new LC581().findUnsortedSubarray(nums));
    }

    /**
     * ����һ: ����һ������Ȼ������Ȼ������ԭ������бȽ�
     * ������: ˫ָ��
     */
    public int findUnsortedSubarray(int[] nums) {
        //��ʼ��
        int len = nums.length;
        int min = nums[len - 1], max = nums[0];
        int l = 0, r = -1;

        for (int i = 0; i < len; i++) {
            //������ά�����ֵmax,��ô�ڽ����Ҷ�֮ǰ��������nums[i]����С��max�ģ�
            if (nums[i] < max) {
                r = i;
            } else {
                max = nums[i];
            }

            if (nums[len - 1 - i] > min) {
                l = len - 1 - i;
            } else {
                min = nums[len - 1 - i];
            }
        }

        return r - l + 1;
    }
}
