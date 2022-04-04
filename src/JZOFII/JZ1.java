package JZOFII;

import a_books.Aha.di7izhang.MaximumHeap;

/**
 * 整数除法
 */
public class JZ1 {

    public static void main(String[] args) {
    }

    /**
     * 因为将 -2147483648 转成正数会越界，但是将 2147483647 转成负数，则不会
     * 所以，我们将 a 和 b 都转成负数
     * 时间复杂度：O(n)，n 是最大值 2147483647 --> 10^10 --> 超时
     */
    public int divide(int a, int b) {
        // 32 位最大值：2^31 - 1 = 2147483647
        // 32 位最小值：-2^31 = -2147483648
        // -2147483648 / (-1) = 2147483648 > 2147483647 越界了
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        // 环境只支持存储 32 位整数
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        return sign == 1 ? res : -res;
    }

    /**
     * 优化
     */
    public int divide1(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;

        int ans = 0,valueLimit = -1073741824,kLimit = 1073741823;
        while (a <= b) {
            int value = b,k = 1;
            //由于操作数都是负数，因此在倍增的过程中，如果操作数小于Integer.MIN_VALUE
            //的一半，即value则会发生溢出，所以需要跳过;
            while (value >= valueLimit && a <= value+value) {
                value+=value;
                if (k > kLimit) return Integer.MIN_VALUE;
                k+=k;
            }
            a-=value;
            ans+=k;
        }

        return sign == 1 ? ans : -ans;
    }
}
