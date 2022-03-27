package Top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * 数组中不包含重复元素
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

    public void backTrack(int [] nums,int count,int begin){
        if (count==tans.size()){
            ans.add(new ArrayList<>(tans));
        }

        for (int i = begin; i < nums.length; i++) {
            tans.add(nums[i]);
            backTrack(nums,count,i+1);
            tans.remove(tans.size()-1);
        }
    }
}
