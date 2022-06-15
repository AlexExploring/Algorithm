package backTrack.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和II （相关题目LC216 组合总和III）
 *
 * 注意：有重复元素，同一元素不可被重复选择
 */
public class LC40 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(0,candidates,target,0);
        return ans;
    }

    public void backTrack(int cur,int [] candidates,int target,int sum){
        if (sum == target){
            ans.add(new ArrayList<>(tans));
        }

        for (int i = cur; i < candidates.length; i++) {
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，但由于从该位置起的所有结果已经在该值第一次使用后得到，故
            // 再在同样的位置使用同样的值结果一定发生重复，因此跳过，用 continue
            if (i > cur && candidates[i] == candidates[i-1]) continue; //同一层当中
            if (sum + candidates[i] > target) break;
            tans.add(candidates[i]);
            //元素不可重复利用，故i+1；
            backTrack(i+1,candidates,target,sum + candidates[i]);
            tans.remove(tans.size()-1);
        }
    }
}
