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
     *ע�⣬����ڶ���ѭ����ʱ�򣬻���С����ѭ���Ļ�����ô
     *
     *         dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i]] + w[i])
     *         ʵ���ϱ����
     *         dp[i][j] = Math.max(dp[i][j], dp[i][j-v[i]] + w[i]);
     *
     *         ��Ϊi-1��ֵ�Ѿ���ǰ�汻���¹��ˣ�������
     *         Ϊ�˱���������⣬����Ҫ������£����ȸ��µ�i����Ȼ����µ�i-1�����Ӷ���֤��i-1����������
     *
     *         ���������Ļ���������Ϊ10��dp����ʵ��Ϊ��
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
