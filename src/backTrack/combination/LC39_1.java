package backTrack.combination;

/**
 * @author zhxspacex
 * @date 2021/1/12 23:34
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *优化版本
 */
public class LC39_1 {
    public static void main(String[] args) {
        LC39_1 a = new LC39_1();
        int [] can = {2,3,6,7};
        int target = 7;
        System.out.println(a.combinationSum(can,target));
    }
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(0,0,candidates,target);
        return ans;
    }

    public void backTrack(int cur,int sum,int [] candidates,int target){
        if (sum ==target){
            ans.add(new ArrayList<Integer>(tans));
            System.out.println("加入"+tans);
            return;
        }

//        i==cur很关键
//        主要就分成两部分，一直选取某一个数，和选取下一个数
        for (int i = cur; i < candidates.length; i++) {

            if (sum +candidates[i]<=target){
                System.out.println("sum="+sum);
                tans.add(candidates[i]);
                System.out.println("i="+i+" "+"tans="+tans);
//              由于一个元素可以被重复使用，所以这里递归式中仍然是i
                backTrack(i,sum+candidates[i],candidates,target);
                tans.remove(tans.size()-1);
                System.out.println("i="+i+" "+"tans="+tans+"sum="+sum);
            }
            else {
                break;
            }
        }
    }
}
