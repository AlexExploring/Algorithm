package JZOFII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿的最大面积 （和LC695相同）
 */
public class JZ105 {

    public static void main(String[] args) {
        int [][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0}
        ,{0,0,0,0,0,0,0,1,1,1,0,0,0}
        ,{0,1,1,0,1,0,0,0,0,0,0,0,0}
        ,{0,1,0,0,1,1,0,0,1,0,1,0,0}
        ,{0,1,0,0,1,1,0,0,1,1,1,0,0}
        ,{0,0,0,0,0,0,0,0,0,0,1,0,0}
        ,{0,0,0,0,0,0,0,1,1,1,0,0,0}
        ,{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        boolean [][] vis = new boolean[grid.length][grid[0].length];
        int ans = new JZ105().bfs(3, 8, grid.length, grid[0].length, grid, vis);
        System.out.println(ans);
    }

    /**
     * 方法一：使用bfs计算每个小岛的面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0,m = grid.length,n = grid[0].length;
        boolean [][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int tans = bfs(i, j, m, n, grid, vis);
                    max = Math.max(tans,max);
                }
            }
        }
        return max;
    }

    public int bfs(int x,int y,int m,int n,int [][] grid,boolean [][] vis) {
        int [][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        vis[x][y] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int [] cell = queue.poll();
            x = cell[0];y = cell[1];
            for (int[] dir : directions) {
                int tx = dir[0] + x;
                int ty = dir[1] + y;
                if (tx < 0|| tx >= m || ty < 0 || ty >= n || grid[tx][ty] == 0 || vis[tx][ty] == true) {
                    continue;
                }
                queue.offer(new int[]{tx,ty});
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    /**
     * 方法二：使用dfs计算每个小岛的面积
     */
    public int maxAreaOfIsland1(int[][] grid) {
        int max = 0;
        boolean [][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(i, j, grid,vis));
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] grid,boolean [][] vis) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length ||
                grid[i][j] == 0 || vis[i][j] == true) {
            return 0;
        }
        vis[i][j] = true;
        int num = 1;
        num += dfs(i + 1, j, grid,vis);
        num += dfs(i - 1, j, grid,vis);
        num += dfs(i, j + 1, grid,vis);
        num += dfs(i, j - 1, grid,vis);
        return num;
    }
}

