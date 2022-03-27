package JZOF;

/**
 *数组中的逆序对
 */
public class JZ51 {
    public static void main(String[] args) {
        int [] nums = {7,5,6,4};
        System.out.println(reversePairs(nums));
    }

    /**
     *暴力 超出时间限制
     */
    public static int reversePairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]<nums[i]) res++;
            }
        }
        return res;
    }


}
