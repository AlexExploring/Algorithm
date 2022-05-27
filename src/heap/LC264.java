package heap;

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
public class LC264 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber2(3));
    }

    /**
     * 最小堆
     */
    public static int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        //每次取最小堆中堆顶元素分别和factors中的元素相乘，可能会产生重复元素，所以用一个set来判重。
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
                //seen中不存在next，才会将next添加到堆中
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }

        return ugly;
    }

    /**
     * 暂时没看懂
     *
     * 丑数的递推性质： 丑数只包含因子 2, 3, 5，因此有 丑数 = 某较小丑数 * （2，3，5中的一个）
     * 官方题解链接：https://leetcode.cn/problems/ugly-number-ii/solution/chou-shu-ii-by-leetcode-solution-uoqd/
     */
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
