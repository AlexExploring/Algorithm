package Top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集I
 *
 * 题目：给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
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
     * @param count 用来标记当前子集的元素个数
     * @param begin 下一层次选择的起始位置，不能重复选择
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
     * 开始假设输出子集为空
     * 遍历数组，对于数组中的每一个整数，每一步都向输出子集中所有子集添加这个整数，并生成新的子集。
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();//存储新num产生的新子集
            for (List<Integer> subset : ans) {
                List<Integer> newSubset = new ArrayList<>(subset); //复制结果中的子集
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            //将新产生的所有子集添加到最终结果中
            ans.addAll(newSubsets);
        }
        return ans;
    }
}
