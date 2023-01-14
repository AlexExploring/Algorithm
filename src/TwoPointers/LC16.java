package TwoPointers;

import java.util.Arrays;

/**
 * ��ӽ�������֮��
 *
 * ����һ������Ϊ n ����������nums�� һ��Ŀ��ֵtarget��
 * ����� nums ��ѡ������������ʹ���ǵĺ���target��ӽ���
 *
 * �������������ĺ͡�
 */
public class LC16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE,ans = 0,len = nums.length;

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1])  continue;
            int l = i + 1,r = len - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    //��ȥ�ش����Ч�ʻ�ȡ�����������ظ����ֵĶ��٣�����ظ����ֺ��ٵĻ�
                    //��ȥ�صĴ��뷴���ή��Ч��
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                } else {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                }
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    ans = sum;
                }
            }
        }

        return ans;
    }
}