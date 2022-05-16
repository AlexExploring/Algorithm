package DP.matrix;

import java.util.List;

/**
 * ����������С·��֮�ͣ���LC120��ͬ��
 */
public class LC120 {

    /**
     * ���ϵ��µĶ�̬�滮
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            //�����һ��
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            //�������һ��
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        int min = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        return min;
    }

    /**
     * �ռ临�Ӷ��Ż�
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }

        //����int min = Arrays.stream(dp).min().getAsInt();
        int min = dp[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min,dp[i]);
        }
        return min;
    }

    /**
     * ���µ��϶�̬�滮
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] ��ʾ�ӵ� (i, j) ���ױߵ���С·���͡�
        int[][] dp = new int[n + 1][n + 1];
        // �������ε����һ�п�ʼ���ơ�
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * �ռ临�Ӷ��Ż�
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
     * �ݹ�
     */
    public int minimumTotal4(List<List<Integer>> triangle) {
        return  dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        return Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }

    /**
     * ���仯�ݹ�
     */
    Integer [][] memo;
    public int minimumTotal5(List<List<Integer>> triangle) {
        memo = new Integer[triangle.size()][triangle.size()];
        return  dfs(triangle, 0, 0);
    }

    private int dfs5(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        return memo[i][j] = Math.min(dfs5(triangle, i + 1, j), dfs5(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
    }
}
