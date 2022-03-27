package backTrack.combination;

import java.util.*;

/**
 *��֦�Ż�
 *
 * https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
 */
public class LC216_1 {
    public static void main(String[] args) {
        LC216_1 a = new LC216_1();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        a.combine(n,k);
    }


    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> tans = new ArrayDeque<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n, k, 1);
        return ans;
    }

    private void dfs(int n, int k, int begin) {
        if (tans.size() == k) {
            ans.add(new ArrayList<>(tans));
            System.out.println(tans);
            return;
        }

        //ͬһ���У�i<=��һ������������Ͻ�

        //���������Ͻ� + ������Ҫѡ���Ԫ�ظ��� - 1 = n
        //���У�������Ҫѡ���Ԫ�ظ��� = k - path.size()������õ���
        //���������Ͻ� = n - (k - path.size()) + 1
        for (int i = begin; i <= n - (k - tans.size()) + 1; i++) {
            tans.addLast(i);
            dfs(n, k, i + 1);
            tans.removeLast();
        }
    }
}
