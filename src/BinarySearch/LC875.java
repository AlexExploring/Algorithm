package BinarySearch;

import java.util.Arrays;

/**
 * 狒狒吃香蕉
 */
public class LC875 {

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = (int) Math.pow(10,9);
        //或者
        //int right = Arrays.stream(piles).max().getAsInt();
        while (left < right) {
            int mid = left + (right-left)/2;
            if (!possible(piles,h,mid)) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 判断能否以k的速度在h内吃完
     */
    public boolean possible(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles)
            time += (pile-1) / k + 1;
        return time <= h;
    }
}
