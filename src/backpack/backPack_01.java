package backpack;

import java.util.Scanner;

/**
 *��⣺https://www.acwing.com/solution/content/1374/
 *
 * 0 1 ����
 */
public class backPack_01 {
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

    /**
     * dp[i][j]��ʾǰi����Ʒ����������j�µ�����ֵ
     */
    static int [][] dp = new int[1001][1001];
    public static int solve(int n,int v,int [] V,int [] W){
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                if (j<V[i]){
                    //����ѡ
                    dp[i][j] = dp[i-1][j];
                }else {
                    //ѡ���߲�ѡ
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-V[i]]+W[i]);
                }
            }
        }
        return dp[n][v];
    }
}
