package BinarySearch;

import java.util.Arrays;

/**
 * ·Ù·Ù≥‘œ„Ω∂
 */
public class JZ73 {

    public static void main(String[] args) {
        int [] data = new int[]{30,11,23,4,20};
        System.out.println(new JZ73().minEatingSpeed(data,6));
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = (int) Math.pow(10,9);
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (!possible(piles,h,mid)) {
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return left;
    }

    public boolean possible(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles)
            time += (pile-1) / k + 1;
        return time <= h;
    }
}
