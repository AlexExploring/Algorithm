package JZOF;

/**
 *�����е������
 */
public class JZ51 {
    public static void main(String[] args) {
        int [] nums = {7,5,6,4};
        System.out.println(reversePairs(nums));
    }

    /**
     *���� ����ʱ������
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
