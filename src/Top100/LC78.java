package Top100;

import java.util.ArrayList;
import java.util.List;

/**
 * �Ӽ�I
 *
 * ��Ŀ������һ���������� nums �������е�Ԫ�� ������ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����
 * �⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��
 */
public class LC78 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            backTrack(nums,i,0);
        }
        return ans;
    }

    /**
     * @param count ������ǵ�ǰ�Ӽ���Ԫ�ظ���
     * @param begin ��һ���ѡ�����ʼλ�ã������ظ�ѡ��
     */
    public void backTrack(int [] nums,int count,int begin){
        if (count==tans.size()){
            ans.add(new ArrayList<>(tans));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            tans.add(nums[i]);
            backTrack(nums,count,i+1);
            tans.remove(tans.size()-1);
        }
    }


    /**
     * ��ʼ��������Ӽ�Ϊ��
     * �������飬���������е�ÿһ��������ÿһ����������Ӽ��������Ӽ��������������������µ��Ӽ���
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();//�洢��num���������Ӽ�
            for (List<Integer> subset : ans) {
                List<Integer> newSubset = new ArrayList<>(subset); //���ƽ���е��Ӽ�
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            //���²����������Ӽ���ӵ����ս����
            ans.addAll(newSubsets);
        }
        return ans;
    }
}
