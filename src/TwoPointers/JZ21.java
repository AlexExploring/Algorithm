package TwoPointers;

import java.util.Arrays;

/**
 * ��������˳��ʹ����λ��ż��ǰ��
 */
public class JZ21 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new JZ21().exchange2(new int[]{1,2,3,4,5})));
    }

    /**
     * ��β˫ָ�� 1ms
     */
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left < right) {
            //left���ƣ�ֱ��leftָ���ֵΪż��
            if ((nums[left] & 1) != 0) {
                left++;
                continue;
            }
            //right���ƣ�ֱ��rightָ���ֵΪ����
            if ((nums[right] & 1) != 1) {
                right--;
                continue;
            }
            swap(nums,left,right);
            //�����ѱ������������±�
            left++;
            right--;
        }

        return nums;
    }

    /**
     * ��β˫ָ�� 2ms
     */
    public int[] exchange1(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left < right) {
            //left���ƣ�ֱ��leftָ���ֵΪż��
            while (left < right && (nums[left] & 1) == 1) left++;
            //right���ƣ�ֱ��rightָ���ֵΪ����
            while (left < right && (nums[right] & 1) == 0) right--;
            swap(nums,left,right);
            //�����ѱ������������±�
            left++;
            right--;
        }

        return nums;
    }

    /**
     * ����˫ָ�� 2ms
     *
     * �������˫ָ�� fast �� low ��fast ��ǰ�� low �ں�
     * fast ����������ǰ��������λ�ã�low ��������ָ����һ������Ӧ����ŵ�λ��
     * fast ��ǰ�ƶ�����������������ʱ�������� nums[low] ��������ʱ low ��ǰ�ƶ�һ��λ�� .
     * �ظ�����������ֱ�� fast ָ������ĩβ
     */
    public int[] exchange2(int[] nums) {
        int slow = 0, fast = 0;

        while(fast < nums.length){
            //���fastָ�����������
            if((nums[fast] & 1) == 1){
                System.out.println("fast="+fast+"  slow="+slow);
                swap(nums,fast,slow);
                slow++;
            }
            fast++;
        }

        return nums;
    }

    public void swap(int [] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
