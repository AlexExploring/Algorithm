package JZOF.divideAndConquer;

import java.util.Arrays;

public class JZ39 {
    public static void main(String[] args) {

    }

    /**
     *���� ��λ��
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     *���η�
     */
    public int majorityElement2(int[] nums) {
        if (nums.length==1) return nums[0];

        return 0;
    }

    /**
     * ������ʹ��hash ���洢 Ԫ�س��ֵĴ���
     */
}
