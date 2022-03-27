package BinarySearch;

/**
 *��������λ��
 *
 * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ�������������������Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
 *
 * ����Լ������������ظ�Ԫ�ء�
 */
public class LC35 {
    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,0));
    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0,r = nums.length-1;

        while (l<=r){
            int mid = l + (r - l)/2;
            if (target==nums[mid]){
                return mid;
            }
            if (target<nums[mid]){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return l;
    }
}
