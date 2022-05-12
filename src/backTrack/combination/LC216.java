package backTrack.combination;

import java.util.ArrayList;
import java.util.List;
/**
 * ����ܺ�III
 *
 * �ҳ��������֮��Ϊ n �� k ��������ϡ������ֻ������ 1 - 9
 * ��������������ÿ������в������ظ������֡���һ������в����ظ�
 * ѡ��ĳһ������
 *
 * ע�⣺���ظ�Ԫ�أ�ͬһԪ�ز��ɱ��ظ�ѡ��
 */
public class LC216 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(1,n,k,0,0);
        return ans;
    }

    public void backTrack(int begin,int n,int k,int tn,int tk){
        if (tn == n && tk == k){
            ans.add(new ArrayList<>(tans));
        }

        for (int i = begin; i <= 9; i++) {
            //tk+1>1�ɽ���ĳһ�ڵ�����ȫ����֦��
            //tn+i��ͬһ���У�һ�����Ѿ�������������ͬ��֮�����������ĵ㼰��������������֦
            if (tk+1 > k || tn+i > n) break;
            tans.add(i);
            backTrack(i+1,n,k,tn+i,tk+1);
            tans.remove(tans.size()-1);
        }
    }
}
