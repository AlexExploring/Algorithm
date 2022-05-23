package BinarySearch.RotateArray;

/**
 * ������ת��������II
 */
public class LC81 {

    /**
     *������ܺ����ظ�������
     */
    public boolean search(int[] nums, int target) {
        if (nums.length==0) return false;
        if (nums.length==1) return nums[0]==target;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            //����д����ʱ�������������low��high��ӵ�ֵ���ܻ��������
            /**
             * int mid = left + (right - left)/2;
             * */
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                return true;
            }
            if (nums[left]==nums[mid]&&nums[mid]==nums[right]){
                left++;right--;
            }
            //mid�������
            else if (nums[mid] >= nums[left]) {//arr[mid] >= arr[left]
                //target ���λ���м�Ԫ�ص����
                if (nums[mid] > target && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            //mid�Ҳ�����
            else {
                //target ���λ���м�Ԫ�ص��Ҳ�
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
