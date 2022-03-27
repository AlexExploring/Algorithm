package Top100;

/**
 * ���������������ĳ˻�
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

        //ans[i]��ʾi����������ֵĳ˻�
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i-1]*ans[i-1];
        }

        //RΪ�Ҳ�����Ԫ�صĳ˻�
        int R = 1;
        for (int i = nums.length-1; i >=0 ; i--) {
            //��������i����ߵĳ˻�Ϊans[i]���ұ߶�˻�ΪR, ���ұߵ������Ҳ�û�����֣�����R�ĳ�ʼֵΪ1
            ans[i] = ans[i]*R;
            R*=nums[i];
        }

        return ans;
    }
}
