package recursion;

import java.util.Arrays;

public class LC1356 {

    public static void main(String[] args) {
        int [] map = {0,1,2,3,4,5,6,7,8};
    }

    public static int[] sortByBits(int[] arr) {
        int [] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(i)*100000 + arr[i];
            System.out.println(map);
        }
        Arrays.sort(map);
        for (int i = 0; i < map.length; i++) {
            map[i] = map[i]%100000;
        }
        return map;
    }
}
