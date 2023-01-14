package TwoPointers;

import java.util.Arrays;

/**
 * ��������˳��ʹ����λ��ż��ǰ��
 */
public class JZ21 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new JZ21().exchange1(new int[]{1,2,3,4,5})));
    }

    /**
     * ��β˫ָ�� 2ms
     * ��������ż�������ҵ������������������ظ���������
     */
    public int[] exchange(int[] nums) {
        int l = 0, r = nums.length-1;

        while (l < r) {
            //l���ƣ�ֱ��lָ���ֵΪż��
            while (l < r && (nums[l] & 1) == 1) l++;
            //r���ƣ�ֱ��rָ���ֵΪ����
            while (l < r && (nums[r] & 1) == 0) r--;
            swap(nums,l,r);
            //�����ѱ������������±�
            l++;
            r--;
        }

        return nums;
    }

    /**
     * ����˫ָ�� 2ms
     *
     * �������˫ָ�� fast �� low ��fast ��ǰ�� low �ں�
     * fast ��������������������λ�ã�low ��������ָ����һ������Ӧ����ŵ�λ��
     * fast ��ǰ�ƶ�����������������ʱ�������� nums[low] ��������ʱ low ��ǰ�ƶ�һ��λ�� .
     * �ظ�����������ֱ�� fast ָ������ĩβ
     */
    public int[] exchange1(int[] nums) {
        int slow = 0, fast = 0;

        while(fast < nums.length){
            //���fastָ�����������
            if((nums[fast] & 1) == 1){
                swap(nums,fast,slow);
                slow++;
            }
            fast++;
        }

        return nums;
    }

    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
