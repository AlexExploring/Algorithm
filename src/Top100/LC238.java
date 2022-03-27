package Top100;

/**
 * 除自身以外的数组的乘积
 */
public class LC238 {
    public int[] productExceptSelf(int[] nums) {
        int [] L = new int[nums.length];
        int [] R = new int[nums.length];
        int [] ans = new int[nums.length];

        L[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = nums[i-1]*L[i-1];
        }

        R[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            R[i] = nums[i+1]*R[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = L[i]*R[i];
        }

        return ans;
    }

    public int[] productExceptSelf1(int[] nums) {
        int [] ans = new int[nums.length];

        //ans[i]表示i左侧所有数字的乘积
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i-1]*ans[i-1];
        }

        //R为右侧所有元素的乘积
        int R = 1;
        for (int i = nums.length-1; i >=0 ; i--) {
            //对于索引i，左边的乘积为ans[i]，右边额乘积为R, 最右边的数字右侧没有数字，所以R的初始值为1
            ans[i] = ans[i]*R;
            R*=nums[i];
        }

        return ans;
    }
}
