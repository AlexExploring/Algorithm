package TwoPointers;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class JZ21 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new JZ21().exchange2(new int[]{1,2,3,4,5})));
    }

    /**
     * 首尾双指针 1ms
     */
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left < right) {
            //left右移，直到left指向的值为偶数
            if ((nums[left] & 1) != 0) {
                left++;
                continue;
            }
            //right左移，直到right指向的值为奇数
            if ((nums[right] & 1) != 1) {
                right--;
                continue;
            }
            swap(nums,left,right);
            //跳过已被交换的数的下标
            left++;
            right--;
        }

        return nums;
    }

    /**
     * 首尾双指针 2ms
     */
    public int[] exchange1(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left < right) {
            //left右移，直到left指向的值为偶数
            while (left < right && (nums[left] & 1) == 1) left++;
            //right左移，直到right指向的值为奇数
            while (left < right && (nums[right] & 1) == 0) right--;
            swap(nums,left,right);
            //跳过已被交换的数的下标
            left++;
            right--;
        }

        return nums;
    }

    /**
     * 快慢双指针 2ms
     *
     * 定义快慢双指针 fast 和 low ，fast 在前， low 在后
     * fast 的作用是向前搜索奇数位置，low 的作用是指向下一个奇数应当存放的位置
     * fast 向前移动，当它搜索到奇数时，将它和 nums[low] 交换，此时 low 向前移动一个位置 .
     * 重复上述操作，直到 fast 指向数组末尾
     */
    public int[] exchange2(int[] nums) {
        int slow = 0, fast = 0;

        while(fast < nums.length){
            //如果fast指向的数是奇数
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
