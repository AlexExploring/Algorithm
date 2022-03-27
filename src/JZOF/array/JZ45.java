package JZOF.array;

import java.util.Arrays;
import java.util.Comparator;

public class JZ45 {
    public String minNumber(int[] nums) {
        String [] data = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder tans = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            tans.append(data[i]);
        }
        return new String(tans);
    }
}
