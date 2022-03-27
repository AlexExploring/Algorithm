package JZOF.DP;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 题目和JZ14 一样，但是
 * 要求 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 且 n 的取值范围扩大到 2<=n<=1000
 */
public class JZ14I {
    public static void main(String[] args) {
        System.out.println(cuttingRope2(34));
    }


    public int cuttingRope1(int n) {
        int mod = 1000000007;
        if(n < 4){
            return n - 1;
        }
        long res = 1;
        while(n > 4){
            res = (res*3)%mod;
            n -= 3;
        }
        return (int)((res*n)%mod);
    }


    /**
     *整体直接使用大数处理 而不能在过程中 取余 ，
     * 对于动态规划来说，会影响最终的结果。。。
     */
    public static int cuttingRope2(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        // dp[1] = BigInteger.valueOf(1);
        for(int i = 3; i < n + 1; i++){
            for(int j = 1; j < i; j++){
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));

            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }
}
