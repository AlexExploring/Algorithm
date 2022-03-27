package a_books.algorithm_competition.sev.sev_DP_1_1;

import java.util.Scanner;

/**
 *不考虑硬币的数量
 */
public class coin3 {
    static int money = 251;
    static int [] type = {1,5,10,25,50};
    static int [] dp = new int[251];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        solve();
        while (scan.hasNextInt()){
            int t = scan.nextInt();
            System.out.println(dp[t]);
        }
    }

    public static void solve(){
        dp[0]=1;
        for (int i = 0; i < 5; i++) {
            for (int j = type[i]; j < money; j++) {
                dp[j] = dp[j]+dp[j-type[i]];
            }
        }
    }
}
