package backTrack.combination;

import java.util.*;

/**
 * 组合：无重复数字，n个数中选择k个数,每个数不可重复选择
 *
 * n个数为 [1~n]
 */
public class LC77 {

    private List<List<Integer>> ans = new ArrayList<>();
    private Deque<Integer> tans = new ArrayDeque<>();

    /**
     * 方法一：回溯
     */
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n,k,1);
        return ans;
    }

    public void backTrack(int n,int k,int begin){
        if (tans.size()==k){
            ans.add(new ArrayList<>(tans));
            return;
        }

        for (int i = begin; i <= n; i++) {
            tans.add(i);
            backTrack(n,k,i+1);
            tans.removeLast();
        }
    }
}
