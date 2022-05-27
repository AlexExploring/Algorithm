package BinarySearch;

/**
 * �����������в���Ŀ�� Ԫ�صĵ�һ�������һ��λ�ã����ұ߽磩
 *
 * ��JZ53I��ͬ��ֻ�Ƿ���ֵ��һ��
 */
public class LC34 {

    public int[] searchRange(int[] nums, int target) {
        int left = helper(nums,target-1);
        int right = helper(nums,target)-1;
        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return new int[]{left,right};
        }
        return new int[]{-1,-1};
    }

    /**
     * ����nums�е�һ������Ŀ��ֵ�������±�
     */
    public int helper(int [] nums,int target) {
        int l = 0,r = nums.length-1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (nums[mid] <= target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }
}
