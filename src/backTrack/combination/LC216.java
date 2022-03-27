package backTrack.combination;

import java.util.ArrayList;
import java.util.List;
/**
 *����ܺ�
 *
 * �ҳ��������֮��Ϊ n �� k ��������ϡ�
 * �����ֻ������ 1 - 9 ��������������ÿ������в������ظ������֡�
 * ��һ������в����ظ�ѡ��ĳһ������
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
     *(1)book[i]��Ե���ͬһ���е�ĳһ��ֵ�Ƿ��ѡ���ݹ鷵�غ��������Ϊ��ѡ��״̬
     *(2)tk+1>1�ɽ���ĳһ�ڵ�����ȫ����֦��
     *(3)tn+i��ͬһ���У�һ�����Ѿ�������������ͬ��֮�����������ĵ㼰��������������֦
     *(4)tk>0&&tans.get(tk-1)>=i��tans����Ԫ��ʱ������Ҫ��֤����һ��Ԫ�غ���Ȼ����
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
