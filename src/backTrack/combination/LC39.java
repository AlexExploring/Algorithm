package backTrack.combination;
import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和I （相关题目LC40 组合总和II）
 *
 * 给你一个无重复元素的整数数组candidates和一个目标整数target，找出 candidates
 * 中可以使数字和为目标数 target的所有不同组合，并以列表形式返回。你可以按任意顺序
 * 返回这些组合。candidates 中的同一个数字可以无限制重复被选取。如果至少一个数字
 * 的被选数量不同，则两种组合是不同的。对于给定的输入，保证和为target 的不同组合数
 * 少于150个。
 *
 * 注意：无重复元素，同一元素可被重复选择
 */
public class LC39 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(0,candidates,target,0);
        return ans;
    }

    /**
     * 做加法
     */
    public void backTrack(int begin,int [] candidates,int target,int sum){
        if (sum > target) return;

        if (sum == target){
            ans.add(new ArrayList<Integer>(tans));
            return;
        }

        //画出决策树来理解，如何重复选择某一个数字，
        for (int i = begin; i < candidates.length; i++) {
            tans.add(candidates[i]);
            backTrack(i,candidates,target,sum+candidates[i]);
            tans.remove(tans.size()-1);
        }
    }


    /**
     * 也可以做减法
     */
    public void backTrack1(int begin,int [] candidates,int target){
        if (target < 0) return;

        if (target == 0){
            ans.add(new ArrayList<Integer>(tans));
            return;
        }

        //画出决策树来理解，如何重复选择某一个数字，
        for (int i = begin; i < candidates.length; i++) {
            tans.add(candidates[i]);
            backTrack1(i,candidates,target-candidates[i]);
            tans.remove(tans.size()-1);
        }
    }
}
