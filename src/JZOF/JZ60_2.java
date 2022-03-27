package JZOF;

import java.util.Arrays;

public class JZ60_2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dicesProbability2(11)));
    }

    /**
     *所以状态表示就是这样的：dp[i][j]，表示投掷完i枚骰子后，点数j的出现次数
     */

    public static double[] dicesProbability(int n) {
        int [][] dp = new int[n+1][70];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i ++) {
            for (int j = i; j <= 6*i; j ++) {
                for (int cur = 1; cur <= 6; cur ++) {
                    if (j - cur <= 0) {
                        break;
                    }
                    // 当前点数和j由上一轮中，即i-1 ，点数和为j-cur推导而来
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

    public static double[] dicesProbability2(int n) {
        double[][] dp = new double[n + 1][6 * n + 1];
        dp[1][1] = 1.0 / 6;
        dp[1][2] = 1.0 / 6;
        dp[1][3] = 1.0 / 6;
        dp[1][4] = 1.0 / 6;
        dp[1][5] = 1.0 / 6;
        dp[1][6] = 1.0 / 6;

        for (int i = 2; i < n + 1; i++) {
            for (int j = i; j < 6 * i + 1; j++) {
                // if (j >= i && j <= 6 * i) {
                int k = 1;
                while (j - k >= 1&&k<=6) {
                    dp[i][j] = dp[i][j] + 1.0 / 6 * (dp[i - 1][j - k]);
                    k++;
                }
                // System.out.println(dp[i][j]);
                // dp[i][j] = 1/6*(dp[i - 1][j-1] +dp[i - 1][j-2]+dp[i - 1][j-3]+dp[i - 1][j-4]+dp[i - 1][j-5]+dp[i - 1][j-6] );
                // }
            }
        }
        double[] res = new double[5 * n + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n][n + i];
        }
        return res;
    }

    /**
     *空间优化
     */
    public double[] dicesProbability1(int n) {
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
        }
        return dp;
    }
}
