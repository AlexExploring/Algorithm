package TwoPointers.array;

/**
 * ɾ�����������е��ظ���
 */
public class LC26 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;

        int index = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }
}
