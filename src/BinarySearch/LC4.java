package BinarySearch;

/**
 *Ѱ�����������������λ��
 */
public class LC4 {

    /**
     * ����һ��������  (Ҳ���Ժϲ�������������Ϊһ���µ���������(LC88),)
     *
     * �Ż�������ֻ��Ҫ��¼����ֵ����
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length,len2 = nums2.length;
        if (len1 == 0 && len2 == 0) return 0;
        int tar = ((len1 + len2)/2)+1;
        int [] temp = new int[tar];
        int idx1 = 0,idx2 = 0,index = 0;

        while ((idx1 <  len1 || idx2 < len2) && index < tar) {
            if (idx1 == len1) {
                temp[index++] = nums2[idx2++];
            } else if (idx2 == len2) {
                temp[index++] = nums1[idx1++];

            } else if (nums1[idx1] <= nums2[idx2]) {
                temp[index++] = nums1[idx1++];
            } else {
                temp[index++] = nums2[idx2++];
            }
        }

        if ((len1 + len2)%2 == 0) {
            return (temp[tar-2]+temp[tar-1])/2.0;
        }else {
            return temp[tar-1];
        }
    }

    /**
     * �����������ֲ���  ���ᣬ��������̫����
     */
}
