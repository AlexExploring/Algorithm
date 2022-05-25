package JZOF;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *丑数
 *
 * 只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）
 *
 * 含有质因子并且
 */
public class JZ49 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber2(3));
    }

    /**
     * 最小堆
     */
    public static int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();

        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;

        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }

        return ugly;
    }

    public static int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
