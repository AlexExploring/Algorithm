package JZOFII;

/**
 * 求平方根
 *
 * 相同题目LC69
 */
public class JZ72 {

    public static void main(String[] args) {
        System.out.println(new JZ72().mySqrt(1));
    }

    public int mySqrt(int x) {
        int low = 0, high = x, ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
