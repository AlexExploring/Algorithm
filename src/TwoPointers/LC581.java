package TwoPointers;

/**
 * 最短无序连续子数组
 *
 * 题目：给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组
 * 进行升序排序，那么整个数组都会变为升序排序。
 *
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leet-yhlf/
 */
public class LC581 {

    public static void main(String[] args) {
        int [] nums = new int[]{2,6,8,10,9,15};
        System.out.println(new LC581().findUnsortedSubarray(nums));
    }

    /**
     * 方法一: 拷贝一个数组然后排序，然后再与原数组进行比较
     * 方法二: 双指针
     */
    public int findUnsortedSubarray(int[] nums) {
        //初始化
        int len = nums.length;
        int min = nums[len - 1], max = nums[0];
        int l = 0, r = -1;

        for (int i = 0; i < len; i++) {
            //从左到右维持最大值max,那么在进入右段之前遍历到的nums[i]都是小于max的，
            if (nums[i] < max) {
                r = i;
            } else {
                max = nums[i];
            }

            if (nums[len - 1 - i] > min) {
                l = len - 1 - i;
            } else {
                min = nums[len - 1 - i];
            }
        }

        return r - l + 1;
    }
}
