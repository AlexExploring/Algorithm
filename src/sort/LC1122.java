package sort;

import java.util.*;

/**
 * �����������
 */
public class LC1122 {

    /**
     * ����
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] ans = new int[arr1.length];
        Set<Integer> set = new HashSet<>();
        for (int el2 : arr2) {
            set.add(el2);
        }
        //�������
        int index = 0;
        for (int el2 : arr2) {
            for (int el1 : arr1) {
                if (el2 == el1) {
                    ans[index++] = el2;
                }
            }
        }
        int start = index;
        for (int el1 : arr1) {
            if (!set.contains(el1)) {
                ans[index++] = el1;
            }
        }
        //�����򲿷�����
        Arrays.sort(ans, start, arr1.length);
        return ans;
    }

    /**
     * ��������
     */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int index = 0;
        int[] hash = new int[1001];
        for (int n : arr1) {
            hash[n]++;
        }
        //���������arr2�г��ֵ�����
        for (int n : arr2) {
            while (hash[n]-- > 0) {
                arr1[index++] = n;
            }
        }
        //���ֻ��arr1�г��ֵ�����
        for (int n = 0; n < hash.length; ++n) {
            while (hash[n]-- > 0) {
                arr1[index++] = n;
            }
        }

        return arr1;
    }
}