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

    public int longestConsecutive1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int ans = 0;
        for (Integer num : numSet) {
            if (!numSet.contains(num-1)) {
                int curNum = num;
                int curAns = 1;
                while (numSet.contains(curNum+1)) {
                    curNum += 1;
                    curAns += 1;
                }
                ans = Math.max(ans,curAns);
            }
        }

        return ans;
    }
}

