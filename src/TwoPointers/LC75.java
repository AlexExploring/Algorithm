package TwoPointers;

/**
 * ��ɫ����
 */
public class LC75 {

    /**
     * ��ָ��
     *
     * ֻ��Ҫ�ֱ�0��1��������ȷ��λ�ã���ô2Ҳ��Ȼ����ȷ��λ����
     */
    public void sortColors1(int[] nums) {
        int n = nums.length,ptr = 0;

        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                swap(nums,i,ptr);
                ++ptr;
            }
        }

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
