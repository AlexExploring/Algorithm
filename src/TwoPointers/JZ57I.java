package TwoPointers;

import java.util.HashSet;

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
            int tem = nums[l] + nums[r];
            if (tem > target) r--;
            else if (tem < target) l++;
            else {
                //ע�������ʱ������ѭ�����������ѭ��
                return new int[]{nums[l],nums[r]};
            }
        }

        return new int[0];
    }

    /**
     * ��������ʹ��set
     * ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
     */
    public int[] twoSum1(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target - nums[i])){
                return new int[]{target - nums[i],nums[i]};
            }
            set.add(nums[i]);
        }

        return new int[0];
    }
}
