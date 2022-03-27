package backTrack.arrangement;

/**
 * @author zhxspacex
 * @date 2021/1/22 15:35
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *全排列II
 */
public class LC47 {
    public static void main(String[] args) {
        LC47 a = new LC47();
        int [] nums = {1,1,2};
        System.out.print(a.permuteUnique(nums));
    }
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        int [] book = new int[nums.length];
        Arrays.sort(book);
        backTrack(nums,book);
        return ans;
    }
    
    public void backTrack(int nums [],int book []){
        if (tans.size()==nums.length){
            ans.add(new ArrayList<>(tans));
        }
        //根据题意：画树状图可以知道，重复的排列是在同一层中产生的
        //这里的t用于子同一层中标记相同的数是否重复出现，t的初始值只要不是nums[]中的数都可以
        int t=11;
        for (int i = 0; i < nums.length; i++) {
            if (book[i]==0&&nums[i]!=t){
                book[i]=1;
                t=nums[i];
                tans.add(nums[i]);
                backTrack(nums,book);
                book[i]=0;
                tans.remove(tans.size()-1);
            }else continue;
        }
    }
}
