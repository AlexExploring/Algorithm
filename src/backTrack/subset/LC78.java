package backTrack.subset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 子集I (相关题目LC90 子集II)
 *
 * 题目：给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class LC78 {

    public static void main(String[] args) {
        for (List<Integer> subset : new LC78().subsets2(new int[]{1, 2, 3})) {
            for (Integer integer : subset) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

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
     * 同subsets1
     */
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());

        for (int num : nums) {
            for (int i = res.size() - 1; i >= 0; i--) {
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
    public List<List<Integer>> subsets2(int[] nums) {
        List<Integer> tans = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        int len = nums.length;
        //一共有 (1 << len)子集,从0到(1 << len)，的二进制表示判断该位上的数是否村存在
        for (int mask = 0; mask < (1 << len); ++mask) {
            System.out.println("mask="+mask);
            for (int i = 0; i < len; ++i) {
                // 依次判断mask的第（i+1）位是否为1（从右到左）
                if ((mask & (1 << i)) != 0) {
                    //为1说明对应nums[i]存在，
                    tans.add(nums[i]);
                }
            }
            ans.add(new ArrayList<Integer>(tans));
            tans.clear();
        }

        return ans;
    }
}
