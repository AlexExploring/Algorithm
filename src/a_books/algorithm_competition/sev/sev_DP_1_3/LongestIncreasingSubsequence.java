package a_books.algorithm_competition.sev.sev_DP_1_3;

import java.util.Scanner;

/**
 *hdu1257
 * ��������ϵͳ
 *
 * ����������У�������
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()){
            int n = scan.nextInt();
            int [] high = new int[n+1];
            for (int i = 1; i <= n; i++) {
                high[i] = scan.nextInt();
            }
            System.out.println(LIS(high,n));
        }
    }

    /**
     *dp[i]��ʾ�Ե�i������β������������еĳ���
     */
    public static int LIS(int [] high,int n){
        int ans = 1;
        int [] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (dp[j]>max&&high[j]<high[i])
                    max = dp[j];
                dp[i] = max+1;
                if (dp[i]>ans) ans = dp[i];
            }
        }
        return ans;
    }
}
