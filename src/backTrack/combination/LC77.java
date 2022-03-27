package backTrack.combination;

import java.util.*;

/**
 *无重复数字，n个数中选择k个数
 */
public class LC77 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        combine(n,k);
    }

    static List<List<Integer>> ans = new ArrayList<>();
    static Deque<Integer> tans = new ArrayDeque<>();

    public static List<List<Integer>> combine(int n, int k) {
        System.out.println("进入com");
        backTrack(n,k,1);
        return ans;
    }

    public static void backTrack(int n,int k,int begin){
        if (tans.size()==k){
            ans.add(new ArrayList<>(tans));
            System.out.println(tans);
        }

        //搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
        //其中，接下来要选择的元素个数 = k - path.size()，整理得到：
        //搜索起点的上界 = n - (k - path.size()) + 1
        //所以，我们的剪枝过程就是：把 i <= n 改成 i <= n - (k - path.size()) + 1

        // i<=n - (k - tans.size()) + 1  优化方案
        for (int i = begin; i <= n; i++) {
            tans.add(i);
            backTrack(n,k,i+1);
            tans.removeLast();
        }
    }
}
