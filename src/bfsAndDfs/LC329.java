package bfsAndDfs;

/**
 * ���������·��
 */
public class LC329 {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // memo[i][j]�д洢����,�ԣ�i��j��Ϊ���������·�������ڼ���
    //�ظ����������Ч��
    private int[][] memo;
    private int rows, cols;

    /**
     * ����һ: ���仯�����������
     */
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;
        memo = new int[rows][cols];
        int ans = 0;

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    public int dfs(int[][] matrix, int x, int y) {
        //memo[x][y] != 0 ��Ϊ0��˵��֮ǰ�Ѿ��������
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        //��ǰ��ֵ��Ϊ0��˵��û�м������+1
        ++memo[x][y];
        for (int[] dir : dirs) {
            int tx = x + dir[0], ty = y + dir[1];
            if (tx >= 0 && tx < rows && ty >= 0 && ty < cols
                    && matrix[tx][ty] > matrix[x][y]) {
                memo[x][y] = Math.max(1, dfs(matrix, tx, ty) + 1);
            }
        }

        return memo[x][y];
    }

}
