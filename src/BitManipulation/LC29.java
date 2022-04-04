package BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 *两数相除
 *
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数dividend除以除数divisor得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 */
public class LC29 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE/2);
    }

    /**
     * 直接使用long存储 dividend 和 divisor的绝对值，防止溢出
     */
    public int divide(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        long t = Math.abs((long) a);
        long d= Math.abs((long) b);
        int result = 0;
        for (int i=31; i>=0;i--) {
            if ((t>>i)>=d) {//找出足够大的数2^n*divisor
                result+=1<<i;//将结果加上2^n
                t-=d<<i;//将被除数减去2^n*divisor
            }
        }
        return sign == 1 ? result : -result;//符号相异取反
    }

    /**
     * 题目要求环境只能存储32位整数
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



