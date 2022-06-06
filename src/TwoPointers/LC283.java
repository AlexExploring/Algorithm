package TwoPointers;

/**
 * 移动零
 */
public class LC283 {

    /**
     * 双指针 左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。
     *
     * 右指针不断向右移动，每次右指针指向非零数，则将左右指针对应的数交换，同时左指针右移。
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
     * 将不为0的数直接填到前面，最后再补0
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
