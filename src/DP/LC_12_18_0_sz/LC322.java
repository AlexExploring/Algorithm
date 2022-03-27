package DP.LC_12_18_0_sz;

import java.util.Arrays;
import java.util.Scanner;
//找零钱
public class LC322 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();//n种硬币面额
        int amount = 0;//总金额
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        amount = scan.nextInt();
        Arrays.sort(a);
        int ans = coinChange1(a,amount);
        System.out.println(ans);
    }

    //记忆化搜索


    //动态规划
    public static int coinChange1(int [] a,int amount){
        int max = amount + 1;
        int [] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - a[j]] + 1);
                }
            }
        }

        for (int i = 0; i <= amount; i++) {
            System.out.print(dp[i]+" ");
        }
        System.out.println();
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
