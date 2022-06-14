package BinarySearch.RotateArray;

/**
 * ������ת��������I
 * LC81 ������ת��������II
 * LC153Ѱ����ת���������е���СֵI,
 * LC154Ѱ����ת���������е���СֵII
 */
public class LC33 {

    /**
     * ����Ҫ��nums�в������ظ�������
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            //����д����ʱ�������������low��high��ӵ�ֵ���ܻ��������
            int mid = left + (right - left)/2;

            if(target == nums[mid]) {
                return mid;
            }

            //mid�������
            if(nums[mid] >= nums[left]) {
                //target ���λ���м�Ԫ�ص����
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid-1;
                } else { //λ���Ҳ�
                    left = mid+1;
                }
            } else { //mid�Ҳ�����
                //target ���λ���м�Ԫ�ص��Ҳ�
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
