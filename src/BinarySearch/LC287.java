package BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Ѱ���ظ���
 */
public class LC287 {

    /**
     * ʹ��set����
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

    /**
     * ����  �÷���Ч�����
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new LC287().findDuplicate2(new int[]{1, 3, 4, 2, 2});
    }

    /**
     * ���ֲ���
     * <p>
     * nums�е����ݷ�Χ��[1,n],����n+1������
     * <p>
     * ��[1,n]�ڽ��ж��ֲ���
     */
    public int findDuplicate2(int[] nums) {
        int len = nums.length;
        int left = 1, right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            // ���ݳ���ԭ��С�ڵ��� 4 �ĸ�������ϸ���� 4 ������ʱ�ظ�Ԫ��һ�������� [1..4] ������
            if (cnt > mid) {
                // �ظ�Ԫ��λ������ [left..mid]
                right = mid;
            } else {
                // if ������ȷ���Ժ�else ������������� if �ķ������� [mid + 1..right]
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * ���ֲ���д��II
     */
    public int findDuplicate3(int[] nums) {
        int len = nums.length;
        int left = 1, right = len - 1,ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            if (cnt > mid) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    /**
     * ����ָ��
     */
}