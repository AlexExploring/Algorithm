package DP;

/**
 * ��Ծ��Ϸ
 */
public class LC55 {

    /**
     * ����ÿһ�����Ե����λ�� x����ʹ�� x+1, x+2,?,x+nums[x] ��Щ������λ�ö����Ե��
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        //���Ե�������Ҳ���±�
        int rightMost = 0;

        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost,i+nums[i]);
                //�ӵ�ǰ�±�i���Ե������һ���±�
                if (rightMost >= n-1) {
                    return true;
                }
            }
        }

        return false;
    }
}
