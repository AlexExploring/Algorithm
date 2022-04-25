package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 连续数组
 */
public class LC525 {

    public int findMaxLength(int[] nums) {
        int ans = 0,count = 0;
        //哈希表存储的是 counter 的每个取值第一次出现的下标
        Map<Integer,Integer> map = new HashMap<>();
        //由于空的前缀的元素和为 0，因此在遍历之前，首先在哈希表中存入键值对 (0,-1)
        map.put(count,-1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] ==  1) {
                count++;
            }else count--;

            if (map.containsKey(count)) {
                ans = Math.max(ans,i-map.get(count));
            }else {
                map.put(count,i);
            }
        }

        return ans;
    }
}
