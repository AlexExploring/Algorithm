package a_books.algorithm_competition.sev.sev_DP_1_1;

import java.util.Scanner;

/**
 *����Ӳ�ҵ�����
 */
public class coin4 {

    static int COIN = 101;
    static int money = 300;
    static int [][] dp = new int[money][COIN];
    static int [] type = {1,5,10,25,50};
    public static void main(String[] args) {
        int [] ans = new int[money];
        solve();
        for (int i = 0; i < money; i++) {
            for (int j = 0; j < COIN; j++) {
                ans[i]+=dp[i][j];
            }
        }
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()){
            int t = scan.nextInt();
            System.out.println(ans[t]);
        }
    }


    //dp[i][j]��ʾ��j��Ӳ��ʵ�ֽ��i�ķ�������
    public static void solve(){
        dp[0][0]=1;
        for (int i = 0; i < type.length; i++) {// Ӳ�ҵ���ֵ��
            for (int j = 1; j < COIN; j++) {  //Ӳ������
                for (int k = type[i]; k < money; k++) {
                    dp[k][j] += dp[k-type[i]][j-1];
                    System.out.println(dp[k][j]);
                }
            }
        }
    }
}
