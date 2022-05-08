package sort;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 *
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 */
public class LC88 {
    public static void main(String[] args) {

    }

    /**
     * Params:
     * src – the source array.
     * srcPos – starting position in the source array.
     * dest – the destination array.
     * destPos – starting position in the destination data.
     * length – the number of array elements to be copied.
     *
     * public static native void arraycopy(Object src,  int  srcPos,
     *                                         Object dest, int destPos,
     *                                         int length);
     */

    /**
     * 解法1:
     * 时间复杂度：O((m+n)log(m+n))。
     * 空间复杂度：O(log(m+n))。
     *
     * 题目要求nums1的长度为m+n，后n个元素为0，要求nums2的长度为n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }


    /**
     * 解法2:双指针
     *
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(m+n)
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0,p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            //p1+p2-1 p1和p2中只有一个数加了1
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    /**
     * 解法3：逆向双指针
     *
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }
}
