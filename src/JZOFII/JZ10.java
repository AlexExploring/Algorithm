package JZOFII;

import java.util.HashMap;
import java.util.Map;

/**
 * ��Ϊk��������
 */
public class JZ10 {

    /**
     * ����
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int [] sums = new int[nums.length+1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1]+nums[i-1];
        }

        for (int i = 1; i < sums.length; i++) {
            for (int j = i; j < sums.length; j++) {
                if (sums[j]-sums[i-1]==k) ans++;
            }
        }

        return ans;
    }

    /**
     * ǰ׺��+hash
     */
    public int subarraySum1(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1); //ǰ׺��Ϊ0��Ĭ���Ǵ��ڵ�
        int sum = 0,count = 0;
        for (int i=0;i<nums.length;++i) {
            sum += nums[i];
            count += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
