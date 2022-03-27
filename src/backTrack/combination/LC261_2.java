package backTrack.combination;

import java.util.*;

/**
 *思路：按照每一个数，选与不选画二叉树
 */
public class LC261_2 {
    public static void main(String[] args) {
        LC261_2 a = new LC261_2();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        a.combine(n,k);
    }

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    public List<List<Integer>> combine(int n, int k) {
        // 为了防止底层动态数组扩容，初始化的时候传入最大长度
        dfs(1, n, k);
        return res;
    }

    private void dfs(int begin, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 基础版本的递归终止条件：if (begin == n + 1) {
        if (begin > n - k + 1) { //n-k+1是搜索起点上界
            return;
        }
        // 不选当前考虑的数 begin，直接递归到下一层
        dfs(begin + 1, n, k);
        // 不选当前考虑的数 begin，递归到下一层的时候 k - 1，这里 k 表示还需要选多少个数
        path.addLast(begin);
        dfs(begin + 1, n, k - 1);
        // 深度优先遍历有回头的过程，因此需要撤销选择
        path.removeLast();
    }
}
