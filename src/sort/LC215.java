package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 数组中的第K个最大元素
 */
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
     * 基于速排序
     */
    public int findKthLargest1(int[] nums, int k) {
        //nums.length()-k 即为倒数第k个下标，也即为第K大的数字的下标
        return quickSort(nums,0,nums.length-1,nums.length-k);
    }

    public int quickSort(int[] nums, int l, int r,int index) {
        int pos = randomPartition(nums, l, r);
        if (pos == index) {
            return nums[pos];
        }else {
            if (pos < index) return quickSort(nums,pos+1,r,index);
            else return quickSort(nums,l,pos-1,index);
        }
    }

    private Random random = new Random();

    public int randomPartition(int[] nums, int l, int r) {
        // 随机选一个作为我们的主元
        int i = random.nextInt(r - l + 1) + l;
        // 交换r,i处的元素
        swap(nums, r, i);
        return partition(nums, l, r);
    }

    public int partition(int[] nums, int l, int r) {
        int key = nums[r],i = l - 1;
        for (int j = l; j < r; ++j) {
            if (nums[j] <= key) {
                i = i + 1;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    public void swap(int [] array,int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}
