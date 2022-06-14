package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和  (a+b+c == 0)
 *
 * LC1 两数之和
 * LC16 最接近的三数之和
 * LC18 四数之和
 * LC259 较小的三数之和
 */
public class LC15 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    /**
     * 方法一：回溯
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0, 0);
        return ans;
    }

    public void backTrack(int[] nums, int total, int begin) {
        if (tans.size() > 3) return;
        if (tans.size() == 3 && total == 0) {
            ans.add(new ArrayList<>(tans));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            //同一层中不选用相同的数字
            if (i > begin && nums[i] == nums[i - 1]) continue;
            tans.add(nums[i]);
            //i+1 : 每个数只能·选一次
            backTrack(nums, total + nums[i], i + 1);
            tans.remove(tans.size() - 1);
        }
    }

    /**
     * 排序+双指针
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            //前面对数组已经排过序，要使三数之和为0，则第一个数不可能大于0
            if (nums[i] > 0) break;
            //相邻的相同元素不能选择，会产生重复的三元组
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 现在要增加 l，减小 r，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3],
                    // i = 0, l = 1, r = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) l++;
                else r--;
            }
        }

        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1,r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++;r--;
                }else if (sum < 0) l++;
                else r--;
            }
        }
        return ans;
    }

}