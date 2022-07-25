package backTrack.combination;
import java.util.ArrayList;
import java.util.Arrays;
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

    public void backTrack(int begin,int [] candidates,int target,int sum){
        if (sum > target) return;

        if (sum == target){
            ans.add(new ArrayList<Integer>(tans));
            return;
        }

        //��������������⣬����ظ�ѡ��ĳһ�����֣�
        for (int i = begin; i < candidates.length; i++) {
            tans.add(candidates[i]);
            //��ǰѡ����candidates[i],��һ����Ȼ����ѡ��candidates[i],��begin=i;
            backTrack(i,candidates,target,sum+candidates[i]);
            tans.remove(tans.size()-1);
        }
    }

    /**
     * ����Ӽ�֦�Ż�
     */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        //���򣬷�����ݵ�ʱ���֦
        Arrays.sort(candidates);
        backTrack1(0,0,candidates,target);
        return ans;
    }

    public void backTrack1(int begin,int sum,int [] candidates,int target){
        if (sum == target){
            ans.add(new ArrayList<Integer>(tans));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (sum + candidates[i] <= target){
                tans.add(candidates[i]);
                backTrack1(i,sum+candidates[i],candidates,target);
                tans.remove(tans.size()-1);
            } else {
                //����candidates������ģ���� sum+��ǰ���� > target ��
                // ˵����ǰ����������ѡ�񶼲�����Ҫ��break
                break;
            }
        }
    }
}
