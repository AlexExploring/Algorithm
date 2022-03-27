package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * �Ӽ�II
 *
 * �����а����ظ�Ԫ��
 */
public class LC90_LC78 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            backTrack(nums,i,0);
        }
        return ans;
    }

    public void backTrack(int [] nums,int count,int begin) {
        if (count == tans.size()) {
            ans.add(new ArrayList<>(tans));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            if (i > begin && nums[i] == nums[i - 1]) continue; // ͬһ���в�ѡ����ͬ������

            tans.add(nums[i]);
            backTrack(nums, count, i+1);
            tans.remove(tans.size() - 1);
        }
    }
}
