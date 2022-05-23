package BinarySearch.RotateArray;

/**
 *Ѱ����ת���������е���СֵI �����ظ����֣�(�����ĿLC154)
 *
 * �����Ŀ
 * LC154 Ѱ����ת���������е���СֵII
 *
 * ��Ŀ��Ҫ��ֻ���ҵ���С��ֵ�������䷵�أ����Ҹ���û���ظ�������
 */
public class LC153 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        //����� left + 1 ��Ҫô�Ǹ����ֵ�����򣩣�ҪôͻȻ
        // ���򣬵�������Сֵ������������Σ���Сֵ���ǰ�����Ѱ
        // �ҷ�Χ�ڵġ����Ҳ�����������ʾ� right - 1 �Ļ�
        // �����ܾͻ�����Сֵ��
        while (low < high) {
            int mid = low + (high - low) / 2;
            //��LC153.png�� ��ʱ��mid�п��ܾ�����Сֵ��λ��
            if (nums[mid] < nums[high]) {
                high = mid;
                //��LC153I.png����ʱ��mid����������Сֵ��λ��
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
        }

        return nums[low];
    }
}
