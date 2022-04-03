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

    /**
     * 直接使用long存储 dividend 和 divisor的绝对值，防止溢出
     */
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) return Integer.MIN_VALUE;
            if (divisor == -1) return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }

        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
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
    public int divide1(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0;
        }

        //符号相异取反
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        boolean rev = false;
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        List<Integer> candidates = new ArrayList<Integer>();
        candidates.add(divisor);
        int index = 0;
        // 注意溢出
        while (candidates.get(index) >= dividend - candidates.get(index)) {
            candidates.add(candidates.get(index) + candidates.get(index));
            ++index;
        }
        int ans = 0;
        for (int i = candidates.size() - 1; i >= 0; --i) {
            if (candidates.get(i) >= dividend) {
                ans += 1 << i;
                dividend -= candidates.get(i);
            }
        }

        return rev ? -ans : ans;
    }
}



