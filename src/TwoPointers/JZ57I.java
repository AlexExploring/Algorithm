package TwoPointers;

import java.util.HashSet;
import java.util.Set;

/**
 * title����Ϊs����������
 *
 * ��Ŀ������һ����������������һ������s���������в�����������ʹ�����ǵĺ�
 * ������s������ж�����ֵĺ͵���s�����������һ�Լ��ɡ�
 */
public class JZ57I {

    /**
     * ����һ��˫ָ��
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        int l = 0,r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) r--;
            else if (sum < target) l++;
            else return new int[]{nums[l],nums[r]};
        }

        return new int[0];
    }

    /**
     * ��������ʹ��set
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
     */
    public int[] twoSum1(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{target - num,num};
            }
            set.add(num);
        }

        return new int[0];
    }
}
