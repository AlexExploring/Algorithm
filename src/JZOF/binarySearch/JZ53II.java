package JZOF.binarySearch;

/**
 * 0~n-1 中缺失的数字
 */
public class JZ53II {
    public static void main(String[] args) {
        System.out.println(missingNumber1(new int[]{0,1,2,3,4,6,7,8}));
    }

    /**
     *暴力
     */
    public static int missingNumber(int[] nums) {
        int res = 0,flag = 0,i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i]!=i){
                flag = 1;break;
            }
        }
        return flag==1 ? i:nums.length;
    }

    /**
     * 二分  自写
     */
    public static int missingNumber1(int[] nums) {
        if (nums.length==1) return nums[0]==1 ? 0:1;

        if (nums[0]!=0) return 0;

        if (nums[nums.length-1]-nums[0]==nums.length-1) return nums.length;



        int i = 0,j = nums.length-1,res = 0;
        while (i<j){
            int mid = (i+j)/2;
            if (mid-i==nums[mid]-nums[i]) i=mid;
            else j=mid;
            if (nums[j]-nums[i]==2&&j-i==1) {
                res = nums[j]-1;break;
            }
        }
        return res;
    }


    /**
     * 题解
     */
    public int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    /**
     * 优化missingNumber2
     */
    public int missingNumber3(int[] nums) {
        return 0;
    }

}
