package backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集II
 *
 * 相关题目：LC78  子集I
 *
 * 题目：给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class LC90 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    /**
     * 方法一
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            backTrack(nums,i,0);
        }
        return ans;
    }

    /**
     * @param count 用来标记当前子集的元素个数
     * @param begin 下一层次选择的起始位置，不能重复选择
     */
    public void backTrack(int [] nums,int count,int begin){
        if (count==tans.size()){
            ans.add(new ArrayList<>(tans));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，但由于从该位置起
            // 的所有结果已经在该值第一次使用后得到，故再在同样的位置使用同样
            // 的值结果一定发生重复，因此跳过，用 continue
            if (i > begin && nums[i] == nums[i-1]) continue;

            tans.add(nums[i]);
            backTrack(nums,count,i+1);
            tans.remove(tans.size()-1);
        }
    }
}
