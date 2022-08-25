package bfsAndDfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿的最大面积 （和LC695相同）
 *
 * 矩阵
 */
public class LC695 {

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
        int ans = new LC695().bfs(3, 8, grid.length, grid[0].length, grid, vis);
        System.out.println(ans);
    }

    /**
     * 方法一：使用bfs计算每个小岛的面积
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0,row = grid.length,col = grid[0].length;

        boolean [][] vis = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //对每一个可能的位置进行搜索
                if (grid[i][j] == 1) {
                    int tans = bfs(i, j, row, col, grid, vis);
                    max = Math.max(tans,max);
                }
            }
        }

        return max;
    }

    public int bfs(int x,int y,int row,int col,int [][] grid,boolean [][] vis) {
        int [][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();
        //使用含有两个数的数组记录二维坐标
        queue.offer(new int[]{x,y});
        vis[x][y] = true;
        int ans = 1;

        while (!queue.isEmpty()) {
            int [] curr = queue.poll();
            x = curr[0];y = curr[1];
            for (int[] dir : directions) {
                int tx = dir[0] + x;
                int ty = dir[1] + y;
                if (tx < 0|| tx >= row || ty < 0 || ty >= col
                        || grid[tx][ty] == 0 || vis[tx][ty]) {
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
        //边界条件
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length ||
                grid[i][j] == 0 || vis[i][j] == true) {
            return 0;
        }

        vis[i][j] = true;
        //注意：这里的num计算，也可以使用一个成员变量，每次进入此位置
        //时，说明到了一块新地方，直接++即可，后面不用计算，也不需要返回值
        int num = 1;

        //向四个可能的方向移动
        num += dfs(i + 1, j, grid,vis);
        num += dfs(i - 1, j, grid,vis);
        num += dfs(i, j + 1, grid,vis);
        num += dfs(i, j - 1, grid,vis);

        return num;
    }
}

