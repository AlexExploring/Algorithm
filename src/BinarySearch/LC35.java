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
        int [] nums = {1,3,5,7,9};
        System.out.println(new LC35().searchInsert(nums,7));
    }

    //����nums�е�һ����С��Ŀ��ֵ�������±�
    public int searchInsert(int[] nums, int target) {
        int l = 0,r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
}