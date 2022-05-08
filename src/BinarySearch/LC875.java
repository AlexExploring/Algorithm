package BinarySearch;

import java.util.Arrays;

/**
 * �������㽶
 */
public class LC875 {

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = (int) Math.pow(10,9);
        //����
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
     * �ж��ܷ���k���ٶ���h�ڳ���
     */
    public boolean possible(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles)
            time += (pile-1) / k + 1;
        return time <= h;
    }
}
