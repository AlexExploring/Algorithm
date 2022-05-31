package sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺子
 *
 * 根据题意，此 5 张牌是顺子的 充分条件 如下：
 * 1.除大小王外，所有牌 无重复 ;
 * 2.设此 5 张牌中最大的牌为 max ，最小的牌为 min （大小王除外），则需满足：max-min<5(因为大小王可以看成任何数)
 */
public class JZ61 {

    /**
     * set集合+遍历
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (!repeat.add(num)) return false;
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }

    /**
     * 排序+遍历
     */
    public static boolean isStraight1(int[] nums) {
        Arrays.sort(nums);
        //zero 用于统计大小王数量
        int zero = 0;

        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) zero++;
            //若有重复，直接返回false
            else if (nums[i] == nums[i+1]) return false;
        }

        //注意：大小王可以看成任何数字
        //最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nums[zero] < 5;
    }
}
