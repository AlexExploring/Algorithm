package backTrack.combination;
import java.util.ArrayList;
import java.util.List;

/**
 * ����ܺ�I �������ĿLC40 ����ܺ�II��
 *
 * ����һ�����ظ�Ԫ�ص���������candidates��һ��Ŀ������target���ҳ� candidates
 * �п���ʹ���ֺ�ΪĿ���� target�����в�ͬ��ϣ������б���ʽ���ء�����԰�����˳��
 * ������Щ��ϡ�candidates �е�ͬһ�����ֿ����������ظ���ѡȡ���������һ������
 * �ı�ѡ������ͬ������������ǲ�ͬ�ġ����ڸ��������룬��֤��Ϊtarget �Ĳ�ͬ�����
 * ����150����
 *
 * ע�⣺���ظ�Ԫ�أ�ͬһԪ�ؿɱ��ظ�ѡ��
 */
public class LC39 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(0,candidates,target,0);
        return ans;
    }

    /**
     * ���ӷ�
     */
    public void backTrack(int begin,int [] candidates,int target,int sum){
        if (sum > target) return;

        if (sum == target){
            ans.add(new ArrayList<Integer>(tans));
            return;
        }

        //��������������⣬����ظ�ѡ��ĳһ�����֣�
        for (int i = begin; i < candidates.length; i++) {
            tans.add(candidates[i]);
            backTrack(i,candidates,target,sum+candidates[i]);
            tans.remove(tans.size()-1);
        }
    }


    /**
     * Ҳ����������
     */
    public void backTrack1(int begin,int [] candidates,int target){
        if (target < 0) return;

        if (target == 0){
            ans.add(new ArrayList<Integer>(tans));
            return;
        }

        //��������������⣬����ظ�ѡ��ĳһ�����֣�
        for (int i = begin; i < candidates.length; i++) {
            tans.add(candidates[i]);
            backTrack1(i,candidates,target-candidates[i]);
            tans.remove(tans.size()-1);
        }
    }
}
