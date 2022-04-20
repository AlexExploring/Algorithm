package JZOFII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �����еľ���
 */
public class JZ107 {

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        // �����е� 0 ��ӽ���ʼ������
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    vis[i][j] = true;
                }
            }
        }

        // �����������
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
