package backTrack.combination;

import java.util.*;

/**
 *���ظ����֣�n������ѡ��k����
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
        System.out.println("����com");
        backTrack(n,k,1);
        return ans;
    }

    public static void backTrack(int n,int k,int begin){
        if (tans.size()==k){
            ans.add(new ArrayList<>(tans));
            System.out.println(tans);
        }

        //���������Ͻ� + ������Ҫѡ���Ԫ�ظ��� - 1 = n
        //���У�������Ҫѡ���Ԫ�ظ��� = k - path.size()������õ���
        //���������Ͻ� = n - (k - path.size()) + 1
        //���ԣ����ǵļ�֦���̾��ǣ��� i <= n �ĳ� i <= n - (k - path.size()) + 1

        // i<=n - (k - tans.size()) + 1  �Ż�����
        for (int i = begin; i <= n; i++) {
            tans.add(i);
            backTrack(n,k,i+1);
            tans.removeLast();
        }
    }
}
