package JZOF.DP;

import java.io.BufferedReader;
import java.util.Arrays;

/**
 *动态规划
 */
public class JZ14 {
    public static void main(String[] args) {
    }


    /**
     * 动态规划
     *
     * 1.要求长度为n的绳子剪掉后的最大乘积，可以从比前面比n小的绳子转移而来
     * 2.用一个dp数组记录从0到n长度的绳子剪掉后的最大乘积，dp[i]表示长度为i的绳子剪成m
     * 段后的最大乘积
     * 3.我们先把绳子剪掉第一段（长度为j），如果只剪掉长度为1，对最后的乘积无任何增益，所以从长度为2开始剪
     *
     *
     * 遍历过程中，只会有两个选择，减或者不减
     */
    public int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                //
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    /**
     * 贪心法 需要数学证明
     */
    public int cuttingRope2(int n) {
        if(n < 4){
            return n - 1;
        }
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    public int cuttingRope3(int n) {
        // 记忆化递归
        int[] memory = new int[n];   //memory[i]表示当绳子长度为i+1时的最大乘积
        Arrays.fill(memory, -1);       //可有可无的代码
        memory[1] = 1;         //注意这里相当于当n=2时，最大乘积为1
        return backtracking(n, memory);
    }
    private int backtracking(int n, int[] memory){
        if(n == 2) return 1;
        if(memory[n-1] != -1) return memory[n-1];  //剪枝

        int res = -1;
        for(int i=1; i<=n/2; ++i){
            res = Math.max(res,Math.max(i*(n-i), i*backtracking(n-i, memory)));
        }
        memory[n-1] = res;       //记录绳子长度为n时的最大乘积
        return res;
    }
}
