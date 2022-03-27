package backpack;

import java.util.Scanner;

public class backPack_01_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int v = scan.nextInt();
        int [] V = new int[1001];
        int [] W = new int[1001];
        for (int i = 1; i <= n; i++) {
            V[i] = scan.nextInt();
            W[i] = scan.nextInt();
        }
        System.out.println(solve(n,v,V,W));
    }

    static int [] dp = new int[1001];
    /**
     *注意，这里第二层循环的时候，还是小到大循环的话，那么
     *
     *         dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
     *         实际上变成了
     *         dp[i][j] = Math.max(dp[i][j], dp[i][j-v[i]] + w[i]);
     *
     *         因为i-1的值已经在前面被更新过了，覆盖了
     *         为了避免这个问题，所以要逆序更新，即先更新第i个，然后更新第i-1个，从而保证第i-1个不被覆盖
     *
     *         如果不逆序的话，输出结果为10，dp数组实际为：
     *         0 0 0 0 0 0
     *         0 2 4 6 8 10
     *         0 2 4 6 8 10
     *         0 2 4 6 8 10
     *         0 2 4 6 8 10
     */

    public static int solve(int n,int v,int [] V,int [] W){
        for (int i = 1; i <= n; i++) {
            for (int j = v; j >= V[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-V[i]]+W[i]);
            }
        }
        return dp[v];
    }
}
