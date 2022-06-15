package backTrack.arrangement;

/**
 * @author zhxspacex
 * @date 2021/1/20 15:27
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列I (相关题目LC47 全排列II)
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列
 */
public class LC46 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    /**
     * 时间复杂度 O(n*n!)
     * 空间复杂度 O(n)
     */
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        int [] book = new int[len];

        backTrack(book,nums,len);

        return ans;
    }

    public void backTrack(int [] book,int [] nums,int len){
        if (tans.size() == len){
            ans.add(new ArrayList<>(tans));
        }

        // 在非叶子结点处，产生不同的分支，这一操作的语义是：在还未选择的数中依次选择一个
        // 元素作为下一个位置的元素，这显然得通过一个循环实现。
        for (int i = 0; i < len; i++) {
            if (book[i] == 0){
                book[i] = 1;
                tans.add(nums[i]);
                backTrack(book,nums,len);
                // 注意：下面这两行代码发生 「回溯」，回溯发生在从 深层结点 回到 浅层结点
                // 的过程，代码在形式上和递归之前是对称的
                book[i] = 0;
                tans.remove(tans.size()-1);
            }
        }
    }
}
