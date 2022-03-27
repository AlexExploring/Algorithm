package Top100;

import java.util.Arrays;
import java.util.Comparator;

public class LC283 {

    /**
     * ����һ�����λ��ö��
     */
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int left = 0,right = 0;
        if (len>1){
            while(left<len&&right<len){

                while (nums[left]!=0&&left+1<len) {
                    left++;
                }
                right = left;
                while (nums[right]==0&&right+1<len){
                    right++;
                }

                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;

                if (right==len-1||len==len-1) break;
            }
        }

    }

    /**
     * ����Ϊ0����ֱ���ǰ�棬����ٲ�0
     */
    public void moveZeroes1(int[] nums) {
        int i = 0,j = 0;
        for(i = 0 ; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                nums[j++] = nums[i];
            }
        }
        while(j < nums.length)
        {
            nums[j++] = 0;
        }
    }

    /**
     * �������ĵڶ���д��
     */
}
