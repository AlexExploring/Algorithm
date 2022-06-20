package backTrack.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * �Ӽ�I (�����ĿLC90 �Ӽ�II)
 *
 * ��Ŀ������һ���������� nums �������е�Ԫ�� ������ͬ �����ظ��������п��ܵ��Ӽ����ݼ�����
 * �⼯ ���� �����ظ����Ӽ�������԰� ����˳�� ���ؽ⼯��
 */
public class LC78 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    /**
     * ����һ���������п��ܵĽ��
     */
    public List<List<Integer>> subsets(int[] nums) {
        //ÿ�δ�nums��ȡi�����֣�ȥ�������еĿ������
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
        if (count == tans.size()){
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
     * ��������������ʵ���Ӽ�ö��
     * ��ʼ��������Ӽ�Ϊ�ձ������飬���������е�ÿһ��������ÿһ����������Ӽ��������Ӽ��������������������µ��Ӽ���
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();//�洢��num���������Ӽ�
            for (List<Integer> subset : ans) {
                List<Integer> newSubset = new ArrayList<>(subset); //���ƽ���е��Ӽ�
                newSubset.add(num);
                //ʹ�õ������������ϵ�ʱ�򣬱������ļ��ϲ��ܱ��޸ģ�������Ҫ����newSubsets
                newSubsets.add(newSubset);
            }
            //���²����������Ӽ���ӵ����ս����
            ans.addAll(newSubsets);
        }
        return ans;
    }

    /**
     * ͬsubsets1
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());

        for (int num : nums) {
            for (int i = res.size()-1; i >= 0; i--) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(num);
                res.add(newSub);
            }
        }

        return res;
    }

    /**
     * ��ÿһ�����ϣ�ÿ����������״̬�����ڻ򲻴��ڣ�����ʹ�ö����Ʊ�ʾ��
     * ��LC78.png
     */
    public List<List<Integer>> subsets3(int[] nums) {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        int len = nums.length;
        for (int mask = 0; mask < (1 << len); ++mask) {
            for (int i = 0; i < len; ++i) {
                // �����ж�mask�ĵڣ�i+1��λ�Ƿ�Ϊ1�����ҵ���
                if ((mask & (1 << i)) != 0) {
                    //Ϊ1˵����Ӧnums[i]���ڣ�
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
            t.clear();
        }

        return ans;
    }
}
