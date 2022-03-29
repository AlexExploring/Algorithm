package tx50;

/**
 * 删除有序数组中的重复项
 */
public class LC26 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;

        int cur = nums[0],curIndex = 1;
        for (int i = 1; i < len; i++) {
            if (cur != nums[i]) {
                cur = nums[i];
                nums[curIndex++] = nums[i];
            }
        }

        return curIndex;
    }

    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;

        int curIndex = 0;
        for (int i = 1; i < len; i++) {
            if (nums[curIndex] != nums[i]) {
                nums[++curIndex] = nums[i];
            }
        }

        return curIndex+1;
    }
}
