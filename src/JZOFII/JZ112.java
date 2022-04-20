package JZOFII;

/**
 * 最长递增路径 （和LC329相同）
 */
public class JZ112 {

    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    /**
     * 方法一: 记忆化深度优先搜索
     */
    public int longestIncreasingPath(int[][] matrix) {
        rows = matrix.length;
        columns = matrix[0].length;
        // memo[i][j]中存储的是,以（i，j）为起点的最长递增路径
        int[][] memo = new int[rows][columns];
        int ans = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                ans = Math.max(ans, dfs(matrix, i, j, memo));
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int row, int column, int[][] memo) {
        if (memo[row][column] != 0) {
            return memo[row][column];
        }
        //当前的值不为0，说明没有计算过，+1
        ++memo[row][column];
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newColumn = column + dir[1];
            //newRow和newColumn 在范围内，并且matrix[newRow][newColumn] > matrix[row][column]，（保持路径是递增的）
            if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
            }
        }
        return memo[row][column];
    }
}
