package backpack.complete;

import java.util.Scanner;

/**
 *��ȫ������ ÿ����Ʒ����������
 * ��⣺https://www.acwing.com/solution/content/10454/
 */
public class CompleteBackpack {
    static int N = 1010;
    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[][] dp = new int[N][N];

    /**
     * n ��Ʒ����
     * m ��������
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }

        //�Ż���ԭ����ǣ�
        //dp[i][j - v] = max(dp[i - 1][j - v], dp[i - 1][j - 2 * v] + w, dp[i - 1][j - 3 * v] + 2 * w, .....)��
        //��������Ҫ��dp[i][j]��״̬��ʾ�ǣ�
        //dp[i][j]= max(dp[i - 1][j], dp[i - 1][j - v] + w, dp[i - 1][j - 2 * v] + 2 * w, dp[i - 1][j - 3 * v] + 3 * w);
        //��ÿһ��һһ�ȶԣ����ǿ��Եõ�����״̬��ʾ:
        //dp[i][j] = max(dp[i - 1][j], dp[i][j - v] +w)��
        for(int i = 1 ; i <= n ; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i])
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - v[i]] + w[i]);
            }
        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= m; j++) {
//                for (int k = 0; k * v[i] <= j; k++)
//                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * v[i]] + k * w[i]);
//            }
//        }

//         for(int i = 1 ; i<=n ;i++){
//            for(int j = v[i] ; j<=m ;j++) {
//                dp[j] = Math.max(dp[j],dp[j-v[i]]+w[i]);
//            }
//        }

        System.out.println(dp[n][m]);
    }
}