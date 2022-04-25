package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
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
            backTrack(nums, total + nums[i], i + 1);
            tans.remove(tans.size() - 1);
        }
    }

    /**
     * 排序+双指针
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int r = len-1;
            while (l < r) {
                int sum = nums[i]+nums[l]+nums[r];
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