package backTrack.arrangement;

/**
 * @author zhxspacex
 * @date 2021/1/22 17:47
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *官方题解
 */
public class LC47_2 {
    public static void main(String[] args) {
        LC47 a = new LC47();
        int [] nums = {1,1,2};
        System.out.print(a.permuteUnique(nums));
    }
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);//很重要
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    /**
     * @param idx 选择到第几个数
     *
     * 难点在于保证在同一个位置，一个数字只能被选择一次
     */
    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            //vis[i]标记nums[]中的数是否被选择
            //(i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) 判断决策树的同一层，也就是同一个位置的数是否重复出现
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
