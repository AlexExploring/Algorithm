package TwoPointers;

/**
 * 颜色分类
 */
public class LC75 {

    /**
     * 单指针
     *
     * 只需要分别将0和1交换到正确的位置，那么2也自然在正确的位置了
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
