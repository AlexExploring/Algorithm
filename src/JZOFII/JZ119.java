package JZOFII;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 *
 * 和 LC128相同
 */
public class JZ119 {

    /**
     * 先排序，再判断
     */
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;

        Arrays.sort(nums);
        int cur = 1,ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }else if (nums[i]-1 == nums[i-1]) {
                cur++;
            }else {
                ans = Math.max(cur,ans);
                cur = 1;
            }
        }

        return Math.max(cur,ans);
    }

    /**
     * 使用set存储所有的数字
     */
    public int longestConsecutive1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int ans = 0;
        for (Integer num : numSet) {
            //确保每一个连续序列都是从最小的数字开始的
            if (!numSet.contains(num-1)) {
                int curNum = num;
                int curAns = 1;
                while (numSet.contains(++curNum)) {
                    curAns += 1;
                }
                ans = Math.max(ans,curAns);
            }
        }

        return ans;
    }
}

