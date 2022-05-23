package Math.arithmetic;

/**
 * 实现pow(x,n) 即计算 x 的 n 次幂函数（即，x^n ）。
 *
 * 题目的数据范围：
 * -100.0 < x < 100.0
 * -2^31 <= n <= 2^31-1
 * -10^4 <= x^n <= 10^4
 */
public class LC50 {

    public double myPow(double x, long n) {
        return n >= 0 ? quickPow(x, n) : 1.0 / quickPow(x, -n);
    }

    /**
     * 递归
     */
    public double quickPow(double x, long n) {
        if (n == 0)
            return 1.0;
        double temp = quickPow(x, n / 2);//先一直递归到最底层
        return n % 2 == 0 ? temp * temp : temp * temp * x;
    }

    /**
     * 快速幂
     */
    public double quickPow1(double x, long n) {
        double res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }
}