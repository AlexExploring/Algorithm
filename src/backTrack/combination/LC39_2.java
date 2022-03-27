package backTrack.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhxspacex
 * @date 2021/1/12 22:59
 */
public class LC39_2 {
    public static void main(String[] args) {
        LC39_2 a = new LC39_2();
        int [] can = {2,3,5};
        int target = 8;
        System.out.println(a.combinationSum(can,target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> tans = new ArrayList<Integer>();

        backTrack(candidates, target, ans, tans, 0);
        return ans;
    }

    public void backTrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> tans, int idx) {
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
            System.out.println(tans+" "+"t="+idx);
            backTrack(candidates, target - candidates[idx], ans, tans, idx);
            tans.remove(tans.size() - 1);
            System.out.println(tans+" "+"t="+idx);
        }
        // 直接跳过
        backTrack(candidates, target, ans, tans, idx + 1);
    }
    /**
     *大佬的题解
     * https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
     */
}
