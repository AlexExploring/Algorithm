package JZOFII;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 */
public class JZ4 {

    /**
     * map
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (value == 1) {
                ans = key;
                break;
            }
        }
        return ans;
    }

    /**
     * 位运算
     */
    public int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total+=((num>>i)&1);
            }
            if (total%3!=0) {
                ans |= (1<<i);
            }
        }
        return ans;
    }
}
