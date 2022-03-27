package array;

import java.util.Arrays;

/**
 * �ϲ�������������
 *
 * ��������������������nums1 �� nums2�����㽫 nums2 �ϲ���nums1�У�ʹ nums1 ��Ϊһ���������顣
 *
 * ��ʼ��nums1 �� nums2 ��Ԫ�������ֱ�Ϊm �� n ������Լ���nums1 �Ŀռ��С����m + n�������������㹻�Ŀռ䱣������ nums2 ��Ԫ�ء�
 */
public class LC88 {
    public static void main(String[] args) {

    }

    /**
     * Params:
     * src �C the source array.
     * srcPos �C starting position in the source array.
     * dest �C the destination array.
     * destPos �C starting position in the destination data.
     * length �C the number of array elements to be copied.
     *
     * public static native void arraycopy(Object src,  int  srcPos,
     *                                         Object dest, int destPos,
     *                                         int length);
     */

    /**
     *�ⷨ1
     * ʱ�临�Ӷȣ�O((m+n)\log(m+n))O((m+n)log(m+n))��
     * �ռ临�Ӷȣ�O(\log(m+n))O(log(m+n))��
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
//        for (int i = 0; i != n; ++i) {
//            nums1[m + i] = nums2[i];
//        }
        Arrays.sort(nums1);
    }

    /**
     *�ⷨ2
     * ʱ�临�Ӷȣ�O(m+n)O(m+n)��
     * �ռ临�Ӷȣ�O(m+n)O(m+n)
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0,p2 = 0;
        int [] ans = new int[m+n];
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
            //p1+p2-1 p1��p2��ֻ��һ��������1
            sorted[p1 + p2 - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }
    }

    /**
     *����˫ָ��
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