package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * �������ų���С����
 */
public class JZ45 {

    /**
     * �ص����ڶ����������
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
