package JZOF.binarySearch;

import java.util.Scanner;

/**
 * 旋转数组中的最小数字
 *
 * 给定的数据中可能含有重复的数字
 */
public class JZ11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] data = {1,3,5};
        System.out.println(minArray1(data));
    }

    /**
     *暴力  O(n)
     */
    public static int minArray(int[] numbers) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            ans = Math.min(numbers[i],ans);
        }
        return ans;
    }

    /**
     *二分查找  O(log(n))
     */
    public static int minArray1(int[] numbers){
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
