package AdvancedDataStructure.UnionFind;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * ��������
 * ����ʹ�ò��鼯����������
 */
public class LC200 {

    /**
     * ����һ��dfs����
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length,cols = grid[0].length;
        int num_islands = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == '1') {
                    //����һ�ε������ջ�ȷ��һ������
                    dfs(grid, i, j);
                    num_islands++;
                }
            }
        }

        return num_islands;
    }

    /**
     *ʹ��dfs��һ�� 1 ��Χ�������ڵ�һ ����Ϊ0
     */
    public static void dfs(char[][] grid, int i, int j) {
        int rows = grid.length,cols = grid[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }

        //����������λ����Ϊ0
        grid[i][j] = '0';
        //���ĸ�����ݹ�����
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /**
     * �����������
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length,cols = grid[0].length;
        int num_islands = 0;

        //������������
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                //Ϊ1��������
                if (grid[i][j] == '1') {
                    ++num_islands;
                    grid[i][j] = '0';

                    //queue�п��Դ�����,���㱣���±�
                    //Queue<int[]> queue = new LinkedList<>();
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * cols + j);

                    while (!queue.isEmpty()) {
                        int cur = queue.remove();
                        int row = cur / cols,col = cur % cols;

                        //����������Χ�ĸ�����
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            queue.add((row-1) * cols + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < rows && grid[row+1][col] == '1') {
                            queue.add((row+1) * cols + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            queue.add(row * cols + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < cols && grid[row][col+1] == '1') {
                            queue.add(row * cols + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}
