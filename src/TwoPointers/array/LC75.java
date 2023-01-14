package TwoPointers.array;

/**
 * 颜色分类
 * 
 * 给定一个包含红色、白色和蓝色、共n 个元素的数组nums，
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红
 * 色、白色、蓝色顺序排列。
 * 我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 */
public class LC75 {

    /**
     * 单指针
     *
     * 只需要分别将0和1交换到正确的位置，那么2也自然在正确的位置了
     */
    public void sortColors1(int[] nums) {
        int n = nums.length,ptr = 0;

        //确定所有红色元素的位置
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                swap(nums,i,ptr);
                ++ptr;
            }
        }

        //确定所有白色元素的位置
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