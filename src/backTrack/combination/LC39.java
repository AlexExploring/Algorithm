package backTrack.combination;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void backTrack(int begin,int [] candidates,int target,int sum){
        if (sum > target) return;

        if (sum == target){
            ans.add(new ArrayList<Integer>(tans));
            return;
        }

        //画出决策树来理解，如何重复选择某一个数字，
        for (int i = begin; i < candidates.length; i++) {
            tans.add(candidates[i]);
            //当前选择了candidates[i],下一步依然可以选择candidates[i],则begin=i;
            backTrack(i,candidates,target,sum+candidates[i]);
            tans.remove(tans.size()-1);
        }
    }

    /**
     * 排序加剪枝优化
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        //排序，方便回溯的时候剪枝
        Arrays.sort(candidates);
        backTrack1(0,0,candidates,target);
        return ans;
    }

    public void backTrack1(int begin,int sum,int [] candidates,int target){
        if (sum == target){
            ans.add(new ArrayList<Integer>(tans));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (sum + candidates[i] <= target){
                tans.add(candidates[i]);
                backTrack1(i,sum+candidates[i],candidates,target);
                tans.remove(tans.size()-1);
            } else {
                //由于candidates是有序的，如果 sum+当前的数 > target ，
                // 说明当前层后序的所有选择都不符合要求，break
                break;
            }
        }
    }
}
