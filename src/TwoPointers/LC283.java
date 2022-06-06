package TwoPointers;

/**
 * �ƶ���
 */
public class LC283 {

    /**
     * ˫ָ�� ��ָ��ָ��ǰ�Ѿ�����õ����е�β������ָ��ָ����������е�ͷ����
     *
     * ��ָ�벻�������ƶ���ÿ����ָ��ָ���������������ָ���Ӧ����������ͬʱ��ָ�����ơ�
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length, l = 0, r = 0;

        while (r < len) {
            if (nums[r] != 0) {
                swap(nums, l, r);
                l++;
            }
            r++;
        }
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    /**
     * ����Ϊ0����ֱ���ǰ�棬����ٲ�0
     */
    public void moveZeroes1(int[] nums) {
        int i = 0,j = 0;
        for(i = 0 ; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        while(j < nums.length) {
            nums[j++] = 0;
        }
    }
}
