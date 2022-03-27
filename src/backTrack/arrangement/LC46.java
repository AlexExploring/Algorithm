package backTrack.arrangement;

/**
 * @author zhxspacex
 * @date 2021/1/20 15:27
 */

import java.util.ArrayList;
import java.util.List;

/**
 *全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列
 */
public class LC46 {
    public static void main(String[] args) {
        LC46 a = new LC46();
        int[] nums = {1,3,2,4};
        System.out.println(a.permute(nums));
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int [] book = new int[nums.length];
        backTrack(book,nums);
        System.out.println(tans);
        return ans;
    }

    public void backTrack(int [] book,int [] nums){
        if (tans.size()==nums.length){
            ans.add(new ArrayList<>(tans));
            System.out.println(tans);
        }

        for (int i = 0; i < nums.length; i++) {
            if (book[i]==0){
                book[i]=1;
                tans.add(nums[i]);
                backTrack(book,nums);
                book[i]=0;
                tans.remove(tans.size()-1);
            }else continue;
        }
    }
}
