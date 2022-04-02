package JZOFII;

import java.util.Arrays;

/**
 * ���������
 *
 * �� LC128��ͬ
 */
public class JZ119 {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;

        Arrays.sort(nums);
        int cur = 1,ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]-1 != nums[i-1]) {
                ans = Math.max(cur,ans);
                cur = 1;
            }else {
                cur++;
            }
        }
        return ans;
    }
}

