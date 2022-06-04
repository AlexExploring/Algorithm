package prefixSum;

import java.util.HashMap;

/**
 * ��Ϊk��������
 *
 * ���ݷ�Χ��
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class LC560 {

    /**
     * ����
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            // ��������ܻ���һЩ���������Ԫ�أ� ����rightһֱ����������β��
            for (int j = i; j < len; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * ǰ׺��
     */
    public int subarraySum1(int[] nums, int k) {
        int len = nums.length;
        // ����ǰ׺������, pre[i]Ϊǰi�����ĺ�
        int [] pre = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            pre[i] = pre[i-1] + nums[i-1];
        }

        int count = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = i; j <= len; j++) {
                // ����� [i..j]��ע���±�ƫ��
                if (pre[j] - pre[i-1] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * ǰ׺��+��ϣ���Ż�
     *
     * map�У�����ǰ׺�ͣ�ֵ�Ƕ�Ӧǰ׺�ͳ��ֵĴ���
     *
     * ��[i..j] ����������Ϊ k ������������ǿ���ת��Ϊ:pre[j]-pre[i-1]==k
     * ������ɵ÷����������±�i���� pre[i-1] == pre[j]-k.
     * �������ǿ����� j ��β�ĺ�Ϊ k ���������������ʱֻҪͳ���ж��ٸ�ǰ׺��Ϊ
     * pre[j]-k �� pre[i] ���ɡ�
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        //�����±�Ϊ0��Ԫ�أ�ǰ׺��Ϊ0������Ϊ1
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}