package AdvancedDataStructure.UnionFind;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 岛屿数量
 * 可以使用并查集来代替搜索
 */
public class LC200 {

    /**
     * 方法一：dfs搜索
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
                    //这里一次调用最终会确定一个岛屿
                    dfs(grid, i, j);
                    num_islands++;
                }
            }
        }

        return num_islands;
    }

    /**
     *使用dfs将一个 1 周围所有相邻的一 设置为0
     */
    public static void dfs(char[][] grid, int i, int j) {
        int rows = grid.length,cols = grid[0].length;
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }

        //将搜索过的位置置为0
        grid[i][j] = '0';
        //向四个方向递归搜索
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /**
     * 广度优先搜搜
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length,cols = grid[0].length;
        int num_islands = 0;

        //搜索整个矩阵
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                //为1尝试搜索
                if (grid[i][j] == '1') {
                    ++num_islands;
                    grid[i][j] = '0';

                    //queue中可以存数组,方便保存下标
                    //Queue<int[]> queue = new LinkedList<>();
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * cols + j);

                    while (!queue.isEmpty()) {
                        int cur = queue.remove();
                        int row = cur / cols,col = cur % cols;

                        //尝试搜索周围四个方向
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
