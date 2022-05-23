package bfsAndDfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0 1 矩阵
 *
 * 题目：给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，
 * 其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。两个相邻元
 * 素间的距离为 1 。
 */
public class LC542 {

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        //四个方向，上下左右
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();

        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int[] dir : directions) {
                int tx = x + dir[0];
                int ty = y + dir[1];
                if (tx >= 0 && tx < m && ty >= 0 && ty < n && !vis[tx][ty]) {
                    dist[tx][ty] = dist[x][y] + 1;
                    queue.offer(new int[]{tx,ty});
                    vis[tx][ty] = true;
                }
            }
        }

        return dist;
    }
}
