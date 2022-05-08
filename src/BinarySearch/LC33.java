package BinarySearch;

/**
 * ������ת��������I
 *������Ŀ
 * LC81 ������ת��������II
 * LC153Ѱ����ת���������е���СֵI,
 * LC154Ѱ����ת���������е���СֵII
 */
public class LC33 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        System.out.println(search(nums,1));
    }

    /**
     *����Ҫ��nums�в������ظ�������
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            //����д����ʱ�������������low��high��ӵ�ֵ���ܻ��������
            /**
             * int mid = left + (right - left)/2;
             * */
            int mid=(left+right)/2;

            if(target==nums[mid]) {
                return mid;
            }
            //mid�������
            if(nums[mid] >= nums[left]) {//arr[mid] >= arr[left]
                //target ���λ���м�Ԫ�ص����
                if (nums[mid] > target && target >= nums[left])
                    right = mid-1;
                else //λ���Ҳ�
                    left = mid+1;
            }
            //mid�Ҳ�����
            else {
                //target ���λ���м�Ԫ�ص��Ҳ�
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}

