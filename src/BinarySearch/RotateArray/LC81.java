package BinarySearch.RotateArray;

/**
 * ������ת��������II
 */
public class LC81 {

    /**
     * ������ܺ����ظ�������
     *
     * �������������ظ�Ԫ�ص���������ֲ���ʱ���ܻ��� a[l]=a[mid]=a[r]����ʱ�޷��ж�����[l,mid]
     * ������ [mid+1,r] �ĸ�������ġ�
     *
     * ���� nums=[3,1,2,3,3,3,3]��target=2���״ζ���ʱ�޷��ж����� [0,3] ������ [4,6] �ĸ���
     * ����Ķ����������������ֻ�ܽ���ǰ�����������߽��һ���ұ߽��һ��Ȼ�����������ϼ������ֲ��ҡ�
     */
    public boolean search(int[] nums, int target) {
        if (nums.length==0) return false;
        if (nums.length==1) return nums[0]==target;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (target == nums[mid]) {
                return true;
            }

            if (nums[left] == nums[mid] && nums[mid] == nums[right]){
                left++;right--;
            } else if (nums[mid] >= nums[left]) {//mid�������
                //target ���λ���м�Ԫ�ص����
                if (nums[mid] > target && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else { //mid�Ҳ�����
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
