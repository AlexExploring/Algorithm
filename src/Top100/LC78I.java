package Top100;

import java.util.ArrayList;
import java.util.List;

public class LC78I {

    /**
     * 开始假设输出子集为空
     * 遍历数组，对于数组中的每一个整数，每一步都向输出子集中所有子集添加这个整数，并生成新的子集。
     */
    public List<List<Integer>> subsets(int[] nums) {
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
