package backTrack.combination;

import java.util.ArrayList;
import java.util.List;
/**
 *组合总和
 *
 * 找出所有相加之和为 n 的 k 个数的组合。
 * 组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 在一个组合中不能重复选择某一个数字
 */
public class LC216 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3,9));
    }


    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tans = new ArrayList();   
        int [] book = new int[10];
        backTrack(n,k,0,0,book,ans,tans);
        return ans;
    }

    /**
     *(1)book[i]针对的是同一层中的某一个值是否可选，递归返回后必须重置为可选的状态
     *(2)tk+1>1可将以某一节点子树全部剪枝，
     *(3)tn+i在同一层中，一个点已经满足条件，则同层之中所有其他的点及其子树，都被剪枝
     *(4)tk>0&&tans.get(tk-1)>=i当tans中有元素时，就需要保证加入一个元素后依然有序
     */
    public static void backTrack(int n,int k,int tn,int tk,int [] book,List<List<Integer>> ans,List<Integer> tans){
        if (tn==n&&tk==k){
            ans.add(new ArrayList<>(tans));
        }

        for (int i = 1; i <= 9; i++) {
            if (tk+1>k||tn+i>n) break;//(2)(3)
            else if(tk>0&&tans.get(tk-1)>=i)continue;
            else if (book[i]==0){
                book[i]=1;
                tans.add(i);
                backTrack(n,k,tn+i,tk+1,book,ans,tans);
                book[i]=0;//(1)
                tans.remove(tans.size()-1);
            }
        }
    }
}
