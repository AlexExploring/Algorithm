package backTrack.combination;

/**
 * @author zhxspacex
 * @date 2021/1/12 22:09
 */;

import java.util.ArrayList;
import java.util.List;

/**
 *组合总和I
 *
 * 原始版本
 */
public class LC39 {
    public static void main(String[] args) {
        LC39 a = new LC39();
        int [] can = {2,3,6,7};
        int target = 7;
        System.out.println(a.combinationSum(can,target));
    }
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList();
    int t = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(0,candidates,target);
        return ans;
    }

    public void backTrack(int begin,int [] candidates,int target){
        if (t==target){
            System.out.println("加入"+tans);
            ans.add(new ArrayList<Integer>(tans));
            System.out.println("结果:"+ans);
        }else if (t>target) return;
        else {
            //画出决策树来理解，如何重复选择某一个数字，
            for (int i = begin; i < candidates.length; i++) {
                tans.add(candidates[i]);
                t+=candidates[i];
                System.out.println("tans:"+ tans +" "+"t="+t);
                backTrack(i,candidates,target);//重复选择当前的数
                t-=candidates[i];
                tans.remove(tans.size()-1);
                System.out.println("tans:"+ tans+" "+"t="+t);
            }
        }
    }
}
