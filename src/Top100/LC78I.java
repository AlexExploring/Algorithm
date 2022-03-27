package Top100;

import java.util.ArrayList;
import java.util.List;

public class LC78I {

    /**
     * ��ʼ��������Ӽ�Ϊ��
     * �������飬���������е�ÿһ��������ÿһ����������Ӽ��������Ӽ��������������������µ��Ӽ���
     */
    public List<List<Integer>> subsets(int[] nums) {
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
