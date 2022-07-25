package backTrack.arrangement;

/**
 * 下一个排列
 *
 * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/
 *
 * 我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的「大数」与前面的「小数」交换，就能
 * 得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
 * 我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
 * 在尽可能靠右的低位进行交换，需要从后向前查找将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一
 * 个排列应该把 5 和 4 交换而不是把 6 和 4 交换将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序
 * 排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升
 * 序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列。
 *
 * 以上就是求“下一个排列”的分析过程。
 */
public class LC31 {

    public static void main(String[] args) {
        int [] nums = new int[]{1,2,3,5,6,4};
        new LC31().nextPermutation(nums);
    }

    /**
     * 可以处理有重复数字的情况
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从后向前找到 第一个使nums[i] < nums[i+1]的i, 一个尽可能大的小数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //i >= 0，说明下一个序列存在
        if (i >= 0) {
            int j = nums.length - 1;
            //从后向前 第一个使nums[i] < nums[j]的j， 一个尽可能小的大数
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        //此时，由i+1到nums.length-1 必定为降序，这里直接使用双指针，反转这一部分使其为升序
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 将nums从start开始，到nums结尾的数反转
     */
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}