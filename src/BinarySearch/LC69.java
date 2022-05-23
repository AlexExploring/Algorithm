package BinarySearch;

/**
 * 求平方根
 *
 * 相同题目LC69
 */
public class LC69 {

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //(long) mid * mid <= x
            if (x/mid >= mid) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public int mySqrt1(int x) {
        if (x < 2) return x;
        int l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //x >= mid*mid
            if (x/mid >= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }

    public int mySqrt2(int x) {
        if (x < 2) return x;
        int l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == x/mid) {
                return mid;
            } else if (x/mid > mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l - 1;
    }
}
