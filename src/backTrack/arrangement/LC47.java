package backTrack.arrangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC47 {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> perm = new ArrayList<Integer>();
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        vis = new boolean[len];
        Arrays.sort(nums);
        backtrack(nums, len);
        return ans;
    }

    /**
     * 难点在于保证在同一个位置，一个数字只能被选择一次
     *
     * 思路：见LC47I.png 和 LC47II.png
     */
    public void backtrack(int[] nums,int len) {
        if (perm.size() == len) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }

        for (int i = 0; i < len; ++i) {
            //vis[i]标记nums[]中的数是否被选择
            //(i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) 判断决策树的同一层，也就是同一个位置的数是否重复出现
            //即i>0的时候，nums[i]==nums[i-1]，并且，nums[i-1]没有被访问过
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }

            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, len);
            vis[i] = false;
            perm.remove(perm.size()-1);
        }
    }
}