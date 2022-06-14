package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����֮��  (a+b+c == 0)
 *
 * LC1 ����֮��
 * LC16 ��ӽ�������֮��
 * LC18 ����֮��
 * LC259 ��С������֮��
 */
public class LC15 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    /**
     * ����һ������
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0, 0);
        return ans;
    }

    public void backTrack(int[] nums, int total, int begin) {
        if (tans.size() > 3) return;
        if (tans.size() == 3 && total == 0) {
            ans.add(new ArrayList<>(tans));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            //ͬһ���в�ѡ����ͬ������
            if (i > begin && nums[i] == nums[i - 1]) continue;
            tans.add(nums[i]);
            //i+1 : ÿ����ֻ�ܡ�ѡһ��
            backTrack(nums, total + nums[i], i + 1);
            tans.remove(tans.size() - 1);
        }
    }

    /**
     * ����+˫ָ��
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            //ǰ��������Ѿ��Ź���Ҫʹ����֮��Ϊ0�����һ���������ܴ���0
            if (nums[i] > 0) break;
            //���ڵ���ͬԪ�ز���ѡ�񣬻�����ظ�����Ԫ��
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // ����Ҫ���� l����С r�����ǲ����ظ�������: [-2, -1, -1, -1, 3, 3, 3],
                    // i = 0, l = 1, r = 6, [-2, -1, 3] �Ĵ𰸼������Ҫ�ų��ظ��� -1 �� 3
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) l++;
                else r--;
            }
        }

        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1,r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++;r--;
                }else if (sum < 0) l++;
                else r--;
            }
        }
        return ans;
    }

}