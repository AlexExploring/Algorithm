package BitManipulation;

/**
 * 位1的个数
 */
public class LC191 {

    public static void main(String[] args) {
        System.out.println(new LC191().hammingWeight(000100010101));
        System.out.println();
    }

    /**
     * 逐位判断是否为1
     */
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n&1) != 0) {
                ret++;
            }
            n >>= 1;
        }
        return ret;
    }

    /**
     * 位运算优化
     *
     * 观察这个运算：n&(n - 1)，其运算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果。
     * 如：6&(6-1) = 4, 6 = (110)_2, 4 = (100)_2,运算结果 4即为把 6 的二进制位中的最低位的 1 变为 0 之后的结果。
     *
     * 这样我们可以利用这个位运算的性质加速我们的检查过程，在实际代码中，我们不断让当前的 n
     * 与 n - 1做与运算，直到 n 变为 0 即可。因为每次运算会使得 n 的最低位的 1 被翻转
     * (要么处于最高位要么处于最低位)，因此运算次数就等于 n 的二进制位中 1 的个数。
     */
    public int hammingWeight1(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public int hammingWeight2(int n) {
        // HD, Figure 5-2
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }


}
