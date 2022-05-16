package backTrack.combination;

import java.util.*;

/**
 * ��ϣ����ظ����֣�n������ѡ��k����,ÿ���������ظ�ѡ��
 *
 * n����Ϊ [1~n]
 */
public class LC77 {

    private List<List<Integer>> ans = new ArrayList<>();
    private Deque<Integer> tans = new ArrayDeque<>();

    /**
     * ����һ������
     */
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n,k,1);
        return ans;
    }

    public void backTrack(int n,int k,int begin){
        if (tans.size()==k){
            ans.add(new ArrayList<>(tans));
            return;
        }

        for (int i = begin; i <= n; i++) {
            tans.add(i);
            backTrack(n,k,i+1);
            tans.removeLast();
        }
    }
}
