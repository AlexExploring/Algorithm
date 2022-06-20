package backTrack.subset;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集I (相关题目LC90 子集II)
 *
 * 题目：给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class LC78 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    /**
     * 方法一：回溯所有可能的结果
     */
    public List<List<Integer>> subsets(int[] nums) {
        //每次从nums中取i个数字，去回溯所有的可能组合
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
     * 方法二：迭代法实现子集枚举
     * 开始假设输出子集为空遍历数组，对于数组中的每一个整数，每一步都向输出子集中所有子集添加这个整数，并生成新的子集。
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();//存储新num产生的新子集
            for (List<Integer> subset : ans) {
                List<Integer> newSubset = new ArrayList<>(subset); //复制结果中的子集
                newSubset.add(num);
                //使用迭代器遍历集合的时候，被遍历的集合不能被修改，所以需要借助newSubsets
                newSubsets.add(newSubset);
            }
            //将新产生的所有子集添加到最终结果中
            ans.addAll(newSubsets);
        }
        return ans;
    }

    /**
     * 同subsets1
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
     * 对每一个集合，每个数有两种状态，存在或不存在，可以使用二进制表示，
     * 见LC78.png
     */
    public List<List<Integer>> subsets3(int[] nums) {
        List<Integer> t = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        int len = nums.length;
        for (int mask = 0; mask < (1 << len); ++mask) {
            for (int i = 0; i < len; ++i) {
                // 依次判断mask的第（i+1）位是否为1（从右到左）
                if ((mask & (1 << i)) != 0) {
                    //为1说明对应nums[i]存在，
                    t.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(t));
            t.clear();
        }

        return ans;
    }
}
