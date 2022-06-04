package BitManipulation;

/**
 * 2的幂
 *
 * 相关题目：LC326：3的幂，
 */
public class LC231 {

    /**
     * 如果n是2的幂，那么n的二进制表示中，只有最高位是1，其他位都是0
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return true;

        while (n != 1) {
            if (n%2 != 0) return false;
            n/=2;
        }

        return true;
    }

    /**
     * 一个数 n是 2 的幂，当且仅当 n 是正整数，并且 n 的二进制表示中仅包含 1 个 1。
     * 如果n是2的幂，那么n-1除了最高位不为1，其他位都为1， n&(n-1一定为0
     */
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
