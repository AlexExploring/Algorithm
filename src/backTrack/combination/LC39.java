package backTrack.combination;

/**
 * @author zhxspacex
 * @date 2021/1/12 22:09
 */;

import java.util.ArrayList;
import java.util.List;

/**
 *����ܺ�I
 *
 * ԭʼ�汾
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
            System.out.println("����"+tans);
            ans.add(new ArrayList<Integer>(tans));
            System.out.println("���:"+ans);
        }else if (t>target) return;
        else {
            //��������������⣬����ظ�ѡ��ĳһ�����֣�
            for (int i = begin; i < candidates.length; i++) {
                tans.add(candidates[i]);
                t+=candidates[i];
                System.out.println("tans:"+ tans +" "+"t="+t);
                backTrack(i,candidates,target);//�ظ�ѡ��ǰ����
                t-=candidates[i];
                tans.remove(tans.size()-1);
                System.out.println("tans:"+ tans+" "+"t="+t);
            }
        }
    }
}
