package BinarySearch;

/**
 * Ѱ�����������������λ��
 *
 * z
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
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLen = length1 + length2;

        if (totalLen % 2 == 1) {
            int midIndex = totalLen / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLen / 2 - 1, midIndex2 = totalLen / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    /* ��Ҫ˼·��Ҫ�ҵ��� k (k>1) С��Ԫ�أ���ô��ȡ pivot1 = nums1[k/2-1] �� pivot2 = nums2[k/2-1] ���бȽ�
     * ����� "/" ��ʾ����
     * nums1 ��С�ڵ��� pivot1 ��Ԫ���� nums1[0 .. k/2-2] ���� k/2-1 ��
     * nums2 ��С�ڵ��� pivot2 ��Ԫ���� nums2[0 .. k/2-2] ���� k/2-1 ��
     * ȡ pivot = min(pivot1, pivot2)������������С�ڵ��� pivot ��Ԫ�ع��Ʋ��ᳬ�� (k/2-1) + (k/2-1) <= k-2 ��
     * ���� pivot �������Ҳֻ���ǵ� k-1 С��Ԫ��
     * ��� pivot = pivot1����ô nums1[0 .. k/2-1] ���������ǵ� k С��Ԫ�ء�����ЩԪ��ȫ�� "ɾ��"��ʣ�µ���Ϊ�µ� nums1 ����
     * ��� pivot = pivot2����ô nums2[0 .. k/2-1] ���������ǵ� k С��Ԫ�ء�����ЩԪ��ȫ�� "ɾ��"��ʣ�µ���Ϊ�µ� nums2 ����
     * �������� "ɾ��" ��һЩԪ�أ���ЩԪ�ض��ȵ� k С��Ԫ��ҪС���������Ҫ�޸� k ��ֵ����ȥɾ�������ĸ���
     */
    public int getKthElement(int[] nums1, int[] nums2, int k) {

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;

        while (true) {
            // �߽����
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // �������
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
