package backTrack.arrangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列II
 *
 * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
 */
public class LC47 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int [] book = new int[nums.length];
        Arrays.sort(book);
        backTrack(nums,book,nums.length);
        return ans;
    }
    
    public void backTrack(int nums [],int book [],int len){
        if (tans.size() == len){
            ans.add(new ArrayList<>(tans));
        }

        //根据题意：画树状图可以知道，重复的排列是在同一层中产生的
        //这里的t用于子同一层中标记相同的数是否重复出现（排序后相同的数会在一起），t的初始值只要不是nums[]中的数都可以
        int t = 11;
        for (int i = 0; i < len; i++) {
            if (book[i] == 0 && nums[i] != t){
                book[i] = 1;
                t = nums[i];
                tans.add(nums[i]);
                backTrack(nums,book,len);
                book[i] = 0;
                tans.remove(tans.size()-1);
            }
        }
    }
}
