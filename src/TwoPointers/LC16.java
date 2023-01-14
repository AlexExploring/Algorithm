package TwoPointers;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。
 * 请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 */
public class LC16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE,ans = 0,len = nums.length;

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1])  continue;
            int l = i + 1,r = len - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    //该去重代码的效率还取决于数据中重复数字的多少，如果重复数字很少的话
                    //该去重的代码反而会降低效率
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                } else {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                }
                if (Math.abs(sum - target) < min) {
                    min = Math.abs(sum - target);
                    ans = sum;
                }
            }
        }

        return ans;
    }
}