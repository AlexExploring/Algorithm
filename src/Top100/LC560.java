package Top100;

import java.util.HashMap;

/**
 * ��Ϊk��������
 */

/**
 * ���Ƶ���Ŀ
 *
 * ����֮��

 * ����֮��

 * ����֮�� II - ������������

 * ����֮�� III - ���ݽṹ���

 * ��Ϊ K ��������

 * ����֮�� IV - ���� BST

 * С�� K ������֮��
 */
public class LC560 {

    /**
     * ����
     */
    public int subarraySum(int[] nums, int k) {

        for (int i = 1; i < nums.length; i++) {
            nums[i]+=nums[i-1];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i!=0){
                    if ((nums[j]-nums[i-1])==k) ans++;
                }else {
                    if (nums[j]==k) ans++;
                }
            }
        }
        return ans;
    }

    /**
     * �Ϸ���һ������һ��
     */
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            int sum = 0;
            // ��������ܻ���һЩ���������Ԫ�أ� ����rightһֱ����������β��
            for (int right = left; right < len; right++) {
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Ҳ��ǰ׺�ͣ��ٶȽз���һ����һ�㣬�ռ临�Ӷ�ΪO(n)
     */
    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        // ����ǰ׺������
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // ����� [left..right]��ע���±�ƫ��
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * ���Ž�
     *
     * https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
     */
    public int subarraySum3(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
