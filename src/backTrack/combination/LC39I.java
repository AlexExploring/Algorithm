package backTrack.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排序+剪枝
 */
public class LC39I {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序，方便回溯的时候剪枝
        Arrays.sort(candidates);
        backTrack(0,0,candidates,target);
        return ans;
    }

    public void backTrack(int begin,int sum,int [] candidates,int target){
        if (sum ==target){
            ans.add(new ArrayList<Integer>(tans));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (sum +candidates[i]<=target){
                tans.add(candidates[i]);
                backTrack(i,sum+candidates[i],candidates,target);
                tans.remove(tans.size()-1);
            } else {
                //由于candidates是有序的，如果 sum+当前的数 > target ，
                // 说明当前层后序的所有选择都不符合要求，break
                break;
            }
        }
    }
}
