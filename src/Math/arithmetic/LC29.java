package Math.arithmetic;

/**
 * 两数相除
 *
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数dividend除以除数divisor得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 */
public class LC29 {

    public int divide(int a,int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        //^ : 异或，对布尔值，相同为false，不同为true
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        return sign == 1 ? res : -res;
    }

    public int divide1(int a,int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        //^ : 异或，对布尔值，相同为false，不同为true
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;

        int ans = 0,valueLimit = -1073741824,kLimit = 1073741823;
        while (a <= b) {
            int value = b,k = 1;
            while (value >= valueLimit && a <= value + value) {
                value += value;
                if (k > kLimit) return Integer.MIN_VALUE;
                k += k;
            }
            a -= value;
            ans += k;
        }
        return sign == 1 ? ans : -ans;
    }
}



