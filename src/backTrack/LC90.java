package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * �Ӽ�II
 *
 * �����Ŀ��LC78  �Ӽ�I
 *
 * ��Ŀ������һ���������� nums �����п��ܰ����ظ�Ԫ�أ����㷵�ظ��������п��ܵ��Ӽ����ݼ�����
 * �⼯ ���� �����ظ����Ӽ������صĽ⼯�У��Ӽ����԰� ����˳�� ���С�
 */
public class LC90 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    /**
     * ����һ
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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
            // С��֦��ͬһ����ͬ��ֵ�Ľ�㣬�ӵ� 2 ����ʼ�������ڴӸ�λ����
            // �����н���Ѿ��ڸ�ֵ��һ��ʹ�ú�õ���������ͬ����λ��ʹ��ͬ��
            // ��ֵ���һ�������ظ�������������� continue
            if (i > begin && nums[i] == nums[i-1]) continue;

            tans.add(nums[i]);
            backTrack(nums,count,i+1);
            tans.remove(tans.size()-1);
        }
    }
}
