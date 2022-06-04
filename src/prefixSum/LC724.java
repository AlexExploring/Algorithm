package prefixSum;

import java.util.Arrays;

/**
 * Ѱ������������±�
 */
public class LC724 {

    /**
     * ǰ׺��
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
     * �Ż�
     *
     * sumΪ��ǰԪ���������Ԫ��֮�ͣ����i��������������һ�����㣺2 * sum + nums[i] == total
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
