package BitManipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都
 * 恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class LC137 {

    /**
     * map
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            //对于num，如果出现过，结果就为已经出现的次数再加1，否则为0再加1
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
            //total%3 一定等于0或1
            if (total%3!=0) {
                //将对应的位数置为1
                ans |= (1<<i);
            }
        }
        return ans;
    }
}
