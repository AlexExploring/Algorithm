package BinarySearch;

/**
 * 0~n-1 ��ȱʧ������
 */
public class JZ53II {

    /**
     *����
     */
    public static int missingNumber(int[] nums) {
        int res = 0,flag = 0,i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i){
                flag = 1;break;
            }
        }

        return flag == 1 ? i : nums.length;
    }

    /**
     * ���ֲ���
     */
    public int missingNumber2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = (l + r) / 2;
            if(nums[m] == m) l = m + 1;
            else r = m - 1;
        }
        return l;
    }
}
