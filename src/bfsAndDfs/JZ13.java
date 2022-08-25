package bfsAndDfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *�����˵��˶���Χ
 *
 * ʹ��BFS
 *
 * ��ʱ5 ms
 */
public class JZ13 {

    /**
     * bfs
     */
    public int movingCount(int m, int n, int k) {
        //����[0,0]��ʼ�ƶ�����Ȼ���ƶ���[1,0]��[0,1]
        if (k == 0) return 1;

        int next[][] = {{0, 1}, {1, 0}};

        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        vis[0][0] = true;
        int ans = 1; //������¼�ܷ��ʵ��ĵ�ĸ���

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx, ty;
            for (int i = 0; i < 2; i++) {
                tx = temp[0] + next[i][0];
                ty = temp[1] + next[i][1];

                if (tx < 0 || tx > m - 1 || ty < 0 || ty > n - 1
                        || vis[tx][ty] || util(tx,ty,k)) continue;

                vis[tx][ty] = true;
                queue.add(new int[]{tx, ty});
                ans++;
            }
        }

        return ans;
    }

    /**
     * �������ݷ�Χ��С��ʹ��dfs����
     */
    public int movingCount1(int m, int n, int k) {
        vis = new boolean[m][n];
        dfs(0, 0, k, m, n);
        return ans;
    }

    private boolean[][] vis;
    private int ans = 0;

    public void dfs(int x, int y, int k, int m, int n){
        if(x < 0 || x >= m || y < 0 || y >= n
                || vis[x][y] || util(x,y,k)){
            return;
        }

        ans++;
        vis[x][y] = true;
        //��������, �ο��ٷ��𰸿�������Ϊ���º����������ŷ���
        dfs(x + 1, y, k, m, n);
        //dfs(x - 1, y, k, m, n);
        dfs(x, y + 1, k, m, n);
        //dfs(x, y - 1, k, m, n);
    }

    /**
     * ���ƣ�
     */
    public int movingCount2(int m, int n, int k) {
        if (k == 0) return 1;

        //vis[i][j]��ʾ��i,j���Ƿ���Ե���
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 && j == 0) || util(i,j,k)) {
                    continue;
                }

                if (i - 1 >= 0) {
                    //vis[i][j] = vis[i][j] || vis[i - 1][j];
                    vis[i][j] |=  vis[i - 1][j];
                }
                if (j - 1 >= 0) {
                    //vis[i][j] = vis[i][j] || vis[i][j - 1];
                    vis[i][j] |= vis[i][j - 1];
                }

                ans += vis[i][j] ? 1 : 0;
            }
        }

        return ans;
    }



    public boolean util(int x, int y, int k) {
        int sum = 0;

        while (x != 0) {
            sum += (x % 10);
            x /= 10;
        }
        while (y != 0) {
            sum += (y % 10);
            y /= 10;
        }

        return sum > k;
    }


}
