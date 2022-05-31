package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * n个骰子的点数
 */
public class JZ60 {

    public static void main(String[] args) {
        double[] res = new JZ60().dicesProbability2(2);
    }

    /**
     * 回溯法
     *
     * 时间复杂度: O(6^n),
     */
    public double[] dicesProbability(int n) {
        double all = Math.pow(6, n);
        HashMap<Integer, Integer> map = new HashMap();

        back_Track(n, 0, 0, map);

        double[] res = new double[map.size()];
        int i = 0;
        for (Integer key : map.keySet()) {
            res[i++] = (map.get(key) / all);
        }

        return res;
    }

    /**
     * 总共右n枚骰子，每一枚骰子右 1~6 六种情况
     */
    public void back_Track(int n, int cur, int total, Map<Integer, Integer> map) {
        if (cur == n) {
            map.put(total, map.getOrDefault(total, 0) + 1);
            return;
        }

        for (int i = 1; i <= 6; i++) {
            back_Track(n, cur + 1, total + i, map);
        }
    }

    /**
     * 动态规划
     * 状态定义:所以状态表示就是这样的：dp[i][j]，表示投掷完i枚骰子后，点数j的出现次数
     *
     * 见图JZ60I.png
     */
    public double[] dicesProbability1(int n) {
        int [][] dp = new int[n+1][70];
        //边界，只有一个骰子的时候，各点数出现的概率
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6*i; j++) {
                for (int cur = 1; cur <= 6; cur++) {
                    if (j - cur <= 0) {
                        break;
                    }
                    // f(n,x) = f(n-1,x-cur)
                    dp[i][j] += dp[i-1][j-cur];
                }
            }
        }

        int all = (int) Math.pow(6,n);
        int len = 5*n+1;
        double [] res = new double[len];
        for (int i = n,j = 0; i <= 6*n; i++,j++) {
            res[j] = dp[n][i]*1.0/all;
        }
        return res;
    }

    /**
     * 动态规划
     *
     * 推到过程见JZ60II.png
     */
    public double[] dicesProbability2(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);

        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
            System.out.println(Arrays.toString(dp));
        }

        return dp;
    }
}