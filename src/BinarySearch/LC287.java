package BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 寻找重复数
 */
public class LC287 {

    /**
     * 使用set集合
     */
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

    /**
     * 排序  该方法效率最低
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new LC287().findDuplicate2(new int[]{1, 3, 4, 2, 2});
    }

    /**
     * 二分查找
     * <p>
     * nums中的数据范围是[1,n],共有n+1个数字
     * <p>
     * 在[1,n]内进行二分查找
     */
    public int findDuplicate2(int[] nums) {
        int len = nums.length;
        int left = 1, right = len - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个，此时重复元素一定出现在 [1..4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left..mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面区间 [mid + 1..right]
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * 二分查找写法II
     */
    public int findDuplicate3(int[] nums) {
        int len = nums.length;
        int left = 1, right = len - 1,ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            if (cnt > mid) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    /**
     * 快慢指针
     */
}