package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 */
public class JZ45 {

    /**
     * 重点在于定义排序规则
     */
    public String minNumber(int[] nums) {
        String [] data = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(data,(x,y) -> (x+y).compareTo(y+x));

        StringBuilder tans = new StringBuilder();
        for (String str : data) {
            tans.append(str);
        }

        return tans.toString();
    }
}
