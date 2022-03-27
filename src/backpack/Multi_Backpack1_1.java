package backpack;

import java.util.Scanner;

public class Multi_Backpack1_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [] v = new int[n+1];
        int [] w = new int[n+1];
        int [] s = new int[n+1];
        int [] dp = new int[1001];

        for (int i = 1; i <= n; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
            s[i] = scan.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 0; --j) {
                for (int k = 1; k <= s[i]; ++k) {
                    if (j>=k*v[i])
                        dp[j] = Math.max(dp[j],dp[j-k*v[i]]+k*w[i]);
                }
            }
        }
        System.out.println(dp[m]);
    }
}
