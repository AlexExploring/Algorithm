package BinarySearch;

import java.util.Arrays;

/**
 * 狒狒吃香蕉
 */
public class LC875 {

    /**
     * 实际上就是通过二分查找找到一最合适的k
     *
     * 狒狒每小时吃的香蕉是 <= piles[i]的，由于题目定义 1<=piles[i]<=10^9
     * 所以二分查找的上界为 10^9
     */
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = (int) Math.pow(10,9);
        //或者
        //int right = Arrays.stream(piles).max().getAsInt();
        while (left < right) {
            int mid = left + (right-left)/2;
            if (!possible(piles,h,mid)) {
                //mid不满足，需要跳过
                left = mid + 1;
            }else {
                //mid可能就是最合适的，所以不能跳过
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
