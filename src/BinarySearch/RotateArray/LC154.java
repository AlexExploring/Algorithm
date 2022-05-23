package BinarySearch.RotateArray;

/**
 * Ѱ����ת���������е���Сֵ II �����ظ����֣��������ĿLC153��
 */
public class LC154 {

    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high -= 1;//�����ȣ�����ȷ��nums[mid]����������Сֵ����໹���Ҳ࣬
                //������ǲ���çײ�غ���ĳһ���ֵ�Ԫ�ء�����Ψһ����֪�����ǣ��������ǵ�
                // ֵ��ͬ���������� numbers[high]
                // �ǲ�����Сֵ������һ�����ġ����Ʒ��nums[mid],
                // ������ǿ��Ժ��Զ��ֲ���������Ҷ˵㡣
            }
        }
        return nums[low];
    }
}
