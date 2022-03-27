package backTrack.combination;

import java.util.*;

/**
 *˼·������ÿһ������ѡ�벻ѡ��������
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
        // Ϊ�˷�ֹ�ײ㶯̬�������ݣ���ʼ����ʱ������󳤶�
        dfs(1, n, k);
        return res;
    }

    private void dfs(int begin, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // �����汾�ĵݹ���ֹ������if (begin == n + 1) {
        if (begin > n - k + 1) { //n-k+1����������Ͻ�
            return;
        }
        // ��ѡ��ǰ���ǵ��� begin��ֱ�ӵݹ鵽��һ��
        dfs(begin + 1, n, k);
        // ��ѡ��ǰ���ǵ��� begin���ݹ鵽��һ���ʱ�� k - 1������ k ��ʾ����Ҫѡ���ٸ���
        path.addLast(begin);
        dfs(begin + 1, n, k - 1);
        // ������ȱ����л�ͷ�Ĺ��̣������Ҫ����ѡ��
        path.removeLast();
    }
}
