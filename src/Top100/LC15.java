package Top100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {


    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();
    /**
     * 超出时间限制
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums,0,0);
        return ans;
    }

    public void backTrack(int [] nums,int total,int begin){
        if (tans.size()>3) return;
        if (tans.size()==3&&total==0){
            ans.add(new ArrayList<>(tans));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            if (i>begin&&nums[i]==nums[i-1]) continue;
            tans.add(nums[i]);
            total+=nums[i];
            backTrack(nums,total,i+1);
            total-=nums[i];
            tans.remove(tans.size()-1);
        }
    }


    /**
     * 方法二
     *
     * 题解：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
     */

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums==null||len<3) return ans;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i]>0) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int L = i+1;
            int R = len-1;
            while (L<R){
                int sum = nums[i]+nums[L]+nums[R];
                if (sum==0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R&&nums[L]==nums[L+1]) L++;
                    while (L<R&&nums[R]==nums[R-1]) R--;
                    L++;R--;
                }else if (sum<0) L++;
                else if (sum>0) R--;
            }
        }
        return ans;
    }
}
