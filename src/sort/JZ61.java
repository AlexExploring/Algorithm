package sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * �˿����е�˳��
 *
 * �������⣬�� 5 ������˳�ӵ� ������� ���£�
 * 1.����С���⣬������ ���ظ� ;
 * 2.��� 5 ������������Ϊ max ����С����Ϊ min ����С�����⣩���������㣺max-min<5(��Ϊ��С�����Կ����κ���)
 */
public class JZ61 {

    /**
     * set����+����
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // ������С��
            max = Math.max(max, num); // �����
            min = Math.min(min, num); // ��С��
            if (!repeat.add(num)) return false;
        }
        return max - min < 5; // ����� - ��С�� < 5 ��ɹ���˳��
    }

    /**
     * ����+����
     */
    public static boolean isStraight1(int[] nums) {
        Arrays.sort(nums);
        //zero ����ͳ�ƴ�С������
        int zero = 0;

        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) zero++;
            //�����ظ���ֱ�ӷ���false
            else if (nums[i] == nums[i+1]) return false;
        }

        //ע�⣺��С�����Կ����κ�����
        //����� - ��С�� < 5 ��ɹ���˳��
        return nums[4] - nums[zero] < 5;
    }
}
