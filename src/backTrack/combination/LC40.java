package backTrack.combination;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *组合总和II
 */
/**
 * @author zhxspacex
 * @date 2021/1/13 11:34
 */
public class LC40 {
    public static void main(String[] args) {
        LC40 a = new LC40();
        int [] can = {2,5,2,1,2};
        int target = 5;
        System.out.println(a.combinationSum2(can,target));
    }

    /**
     *原题解链接
     * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList();
    int t = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(0,candidates,target);
        return ans;
    }

    public void backTrack(int cur,int [] candidates,int target){
        if (t==target){
            ans.add(new ArrayList<>(tans));
        }
        for (int i = cur; i < candidates.length; i++) {
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，但由于从该位置起的所有结果已经在该值第一次使用后得到，故
            // 再在同样的位置使用同样的值结果一定发生重复，因此跳过，用 continue
            if (i>cur && candidates[i]==candidates[i-1]) continue; //同一层当中
            if (t+candidates[i]<=target){
                t+=candidates[i];
                tans.add(candidates[i]);
                //元素不可重复利用，故i+1；
                System.out.println(tans);
                backTrack(i+1,candidates,target);
                t-=candidates[i];
                tans.remove(tans.size()-1);
                System.out.println(tans);
            }else {
                break;
            }
        }
    }
}
