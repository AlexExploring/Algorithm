package TwoPointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *��Ϊs����������
 *
 * ����һ����������������һ������s���������в�����������ʹ�����ǵĺ�������s������ж�����ֵĺ͵���s�����������һ�Լ��ɡ�
 *
 * �����л�����ظ�����
 *
 * ��LC1���ƣ�ֻ��LC1 ��nums���������
 */
public class JZ57 {

    /**
     * ����һ����ϣ��
     * ��ĿҪ��1 <= nums[i] <= 10^6
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{nums[map.get(target-nums[i])],nums[i]};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }


    /**
     *  ʹ��set ʱ�临�Ӷ�O(n)
     *
     *  ��twoSum()�ĺ�ʱ���
     */
    public int[] twoSum1(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        int [] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target-nums[i])){
                ans[0] = target-nums[i];
                ans[1] = nums[i];
                break;
            }
            set.add(nums[i]);
        }
        return ans;
    }

    /**
     * ˫ָ��
     * �ύ ��ʱ2ms
     */
    public int[] twoSum2(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while(i < j) {
            int t = nums[i] + nums[j];
            if(t < target) i++;
            else if(t > target) j--;
            else return new int[] { nums[i], nums[j] };
        }

        return new int[0];
    }
}
