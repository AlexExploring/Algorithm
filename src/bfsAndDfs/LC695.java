package bfsAndDfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����������� ����LC695��ͬ��
 *
 * ����
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
     * ����һ��ʹ��bfs����ÿ��С�������
     */
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0,row = grid.length,col = grid[0].length;

        boolean [][] vis = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //��ÿһ�����ܵ�λ�ý�������
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
        //ʹ�ú����������������¼��ά����
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
     * ��������ʹ��dfs����ÿ��С�������
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
        //�߽�����
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length ||
                grid[i][j] == 0 || vis[i][j] == true) {
            return 0;
        }

        vis[i][j] = true;
        //ע�⣺�����num���㣬Ҳ����ʹ��һ����Ա������ÿ�ν����λ��
        //ʱ��˵������һ���µط���ֱ��++���ɣ����治�ü��㣬Ҳ����Ҫ����ֵ
        int num = 1;

        //���ĸ����ܵķ����ƶ�
        num += dfs(i + 1, j, grid,vis);
        num += dfs(i - 1, j, grid,vis);
        num += dfs(i, j + 1, grid,vis);
        num += dfs(i, j - 1, grid,vis);

        return num;
    }
}

