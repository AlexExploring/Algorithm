package bfsAndDfs;

/**
 * 矩阵最长递增路径
 */
public class LC329 {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    // memo[i][j]中存储的是,以（i，j）为起点的最长递增路径，用于减少
    //重复搜索，提高效率
    private int[][] memo;
    private int rows, cols;

    /**
     * 方法一: 记忆化深度优先搜索
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
        //memo[x][y] != 0 不为0，说明之前已经计算过了
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        //当前的值不为0，说明没有计算过，+1
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
