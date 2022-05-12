package backTrack.combination;

import java.util.ArrayList;
import java.util.List;
/**
 * 组合总和III
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9
 * 的正整数，并且每种组合中不存在重复的数字。在一个组合中不能重复
 * 选择某一个数字
 *
 * 注意：无重复元素，同一元素不可被重复选择
 */
public class LC216 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(1,n,k,0,0);
        return ans;
    }

    public void backTrack(int begin,int n,int k,int tn,int tk){
        if (tn == n && tk == k){
            ans.add(new ArrayList<>(tans));
        }

        for (int i = begin; i <= 9; i++) {
            //tk+1>1可将以某一节点子树全部剪枝，
            //tn+i在同一层中，一个点已经满足条件，则同层之中所有其他的点及其子树，都被剪枝
            if (tk+1 > k || tn+i > n) break;
            tans.add(i);
            backTrack(i+1,n,k,tn+i,tk+1);
            tans.remove(tans.size()-1);
        }
    }
}
