package BinarySearch;

/**
 * ɽ������ķ嶥����
 */
public class LC852 {

    /**
     * ��Ŀ��˼ת��Ϊ�����ֵ���±�
     */
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int ans = -1;
        for (int i = 1; i < n - 1; ++i) {
            if (arr[i] > arr[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * ���ֲ���
     */
    public int peakIndexInMountainArray1(int[] arr) {
        int l = 1, r = arr.length - 2;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] > arr[mid + 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * �ٷ����
     */
    public int peakIndexInMountainArray2(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
