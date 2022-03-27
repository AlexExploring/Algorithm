package tx50;

public class LC231 {
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
     */
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

}
