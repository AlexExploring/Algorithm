package JZOFII;

import java.util.HashMap;
import java.util.Map;

/**
 * 0和1个数相同的子数组
 */
public class JZ11 {
    public int findMaxLength(int[] nums) {
        int ans = 0,count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(count,-1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] ==  1) {
                count++;
            }else count--;

            if (map.containsKey(count)) {
                int prevIndex = map.get(count);
                ans = Math.max(ans,i-prevIndex);
            }else {
                map.put(count,i);
            }
        }

        return ans;
    }
}
