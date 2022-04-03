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
        // 32 位最大值：2^31 - 1 = 2147483647
        // 32 位最小值：-2^31 = -2147483648
        // -2147483648 / (-1) = 2147483648 > 2147483647 越界了
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        // 环境只支持存储 32 位整数
        a = Math.abs(a);
        b = Math.abs(b);

        int res = 0;
        while (a <= b) {
            //value 一轮中最终被减掉的值
            int value = b;
            int k = 1;
            // 0xc0000000 是十进制 -2^30 的十六进制的表示
            // 判断 value >= 0xc0000000 的原因：保证 value + value 不会溢出
            // 可以这样判断的原因是：0xc0000000 是最小值 -2^31 的一半，
            // 而 a 的值不可能比 -2^31 还要小，所以 value 不可能比 0xc0000000 小
            // -2^31 / 2 = -2^30
            while (value >= 0xc0000000 && a <= value + value) {
                value += value;
                // 代码优化：如果 k 已经大于最大值的一半的话，那么直接返回最小值
                // 因为这个时候 k += k 的话肯定会大于等于 2147483648 ，这个超过了题目给的范围
                if (k > Integer.MAX_VALUE / 2) {
                    return Integer.MIN_VALUE;
                }
                k += k;
            }
            a -= value;
            res += k;
        }

        return sign == 1 ? res : -res;
    }
}
