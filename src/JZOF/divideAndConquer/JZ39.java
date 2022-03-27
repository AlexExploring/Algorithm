package JZOF.divideAndConquer;

import java.util.Arrays;

public class JZ39 {
    public static void main(String[] args) {

    }

    /**
     *排序 中位数
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     *分治法
     */
    public int majorityElement2(int[] nums) {
        if (nums.length==1) return nums[0];

        return 0;
    }

    /**
     * 还可以使用hash 来存储 元素出现的次数
     */
}
