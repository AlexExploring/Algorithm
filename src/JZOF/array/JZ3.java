package JZOF.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *�������ظ�������
 *
 * ��һ������Ϊ n ������ nums ����������ֶ��� 0��n-1 �ķ�Χ�ڡ�������ĳЩ��
 * �����ظ��ģ�����֪���м��������ظ��ˣ�Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����
 * ������һ���ظ������֡�
 *
 */
public class JZ3 {
    public static void main(String[] args) {
        int [] nums = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]){
                break;
            }
        }
        return nums[i];
    }


    /**
     * ʱ�临�ӶȺͿռ临�Ӷȶ�ΪO(n)
     */
    public static int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
