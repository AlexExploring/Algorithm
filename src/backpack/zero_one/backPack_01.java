package backpack.zero_one;

/**
 *题解：https://www.acwing.com/solution/content/1374/
 *
 * 0 1 背包
 */
public class backPack_01 {

    /**
     * dp[i][j]表示前i个物品，背包容量j下的最优值
     */
    public int solve(int n,int v,int [] V,int [] W){
        int [][] dp = new int[1001][1001];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= v; j++) {
                if (j<V[i]){
                    //不能选
                    dp[i][j] = dp[i-1][j];
                }else {
                    //选或者不选
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
