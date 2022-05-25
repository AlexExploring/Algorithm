package DP.matrix;

/**
 * ���������ֵ
 */
public class JZ47 {
    public int maxValue(int[][] grid) {
        int m = grid.length,n = grid[0].length;

        int dp[][] = new int[m][n];

        dp[0][0]=grid[0][0];
        //��һ��ֻ�ܴ��ϵ��¶���
        for (int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //��һ��ֻ�ܴ�����
        for (int i=1;i<n;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                //ȷ��ÿһ����󣬴Ӷ��õ����ֵ
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];//grid[i][j]��ʾ�����е�ֵ
            }
        }

        return dp[m-1][n-1];
    }

    /**
     *���������Ż�
     */
    public static int uniquePaths2(int [][] grid){
        int m = grid.length,n = grid[0].length;

        int [] dp = new int[n];
        dp[0] = grid[0][0];
        //�����һ��
        for (int i = 1; i < n; i++) {
            dp[i] += dp[i-1]+grid[0][i];
        }

        for (int i=1;i<m;i++){
            dp[0] += grid[i][0];
            for (int j=1;j<n;j++){
                dp[j] = Math.max(dp[j],dp[j-1])+grid[i][j];
            }
        }

        return dp[n-1];
    }
}
