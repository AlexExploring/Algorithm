package sort;

public class LC215 {

    /**
     * 冒泡排序提前结束
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[len - k];
    }

    /**
     * 快速排序
     */
}
