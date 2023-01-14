package TwoPointers.array;

/**
 * ��ɫ����
 * 
 * ����һ��������ɫ����ɫ����ɫ����n ��Ԫ�ص�����nums��
 * ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�
 * ɫ����ɫ����ɫ˳�����С�
 * ����ʹ������ 0��1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��
 */
public class LC75 {

    /**
     * ��ָ��
     *
     * ֻ��Ҫ�ֱ�0��1��������ȷ��λ�ã���ô2Ҳ��Ȼ����ȷ��λ����
     */
    public void sortColors1(int[] nums) {
        int n = nums.length,ptr = 0;

        //ȷ�����к�ɫԪ�ص�λ��
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                swap(nums,i,ptr);
                ++ptr;
            }
        }

        //ȷ�����а�ɫԪ�ص�λ��
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                swap(nums,i,ptr);
                ++ptr;
            }
        }
    }

    public void swap(int[] nums,int i ,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}