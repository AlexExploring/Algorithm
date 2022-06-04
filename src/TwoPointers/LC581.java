package TwoPointers;

import java.util.Arrays;

/**
 * �����������������
 *
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leet-yhlf/
 */
public class LC581 {

    public static void main(String[] args) {
        int [] nums = new int[]{2,6,4,8,10,9,15};
        System.out.println(new LC581().findUnsortedSubarray1(nums));
    }

    /**
     * ����һ: ����һ������Ȼ������Ȼ������ԭ������бȽ�
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i <= j && nums[i] == arr[i]) i++;
        while (i <= j && nums[j] == arr[j]) j--;
        return j - i + 1;
    }

    /**
     * ������: ˫ָ��
     */
    public int findUnsortedSubarray1(int[] nums) {
        //��ʼ��
        int len = nums.length;
        int min = nums[len - 1], max = nums[0];
        int l = 0, r = -1;
        //����
        for (int i = 0; i < len; i++) {
            //������ά�����ֵmax,��ô�ڽ����Ҷ�֮ǰ��������nums[i]����С��max�ģ�
            System.out.println("nums[i]="+nums[i]+"  max="+max);
            if (nums[i] < max) {
                r = i;
                System.out.println(" r="+r);
            } else {
                max = nums[i];
                System.out.println(" max���£�"+max);
            }

            //���ҵ���ά����Сֵ��Ѱ����߽�l
            if (nums[len - 1 - i] > min) {
                l = len - 1 - i;
            } else {
                min = nums[len - 1 - i];
            }
        }
        return r - l + 1;
    }
}
