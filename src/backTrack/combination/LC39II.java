package backTrack.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯过程的另一种写法
 */
public class LC39II {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> tans = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0);
        return ans;
    }

    public void backTrack(int[] candidates, int target, int idx) {
        if (idx == candidates.length) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<Integer>(tans));
            return;
        }

        //下面这两部分可交换
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            tans.add(candidates[idx]);
            backTrack(candidates, target - candidates[idx], idx);
            tans.remove(tans.size() - 1);
        }
        // 不选当前数直接跳过
        backTrack(candidates, target, idx + 1);
    }
}
