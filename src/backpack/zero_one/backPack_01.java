package backpack.zero_one;

/**
 *��⣺https://www.acwing.com/solution/content/1374/
 *
 * 0 1 ����
 */
public class backPack_01 {

    /**
     * dp[i][j]��ʾǰi����Ʒ����������j�µ�����ֵ
     */
    public int solve(int n,int v,int [] V,int [] W){
        int [][] dp = new int[1001][1001];
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

    public static int solve1(int n,int v,int [] V,int [] W){
        int [] dp = new int[1001];
        for (int i = 1; i <= n; i++) {
            for (int j = v; j >= V[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-V[i]]+W[i]);
            }
        }
        return dp[v];
    }
}
