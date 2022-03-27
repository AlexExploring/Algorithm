package AdvancedDataStructure.UnionFind;

import java.util.LinkedList;
import java.util.Queue;

/**
 *��Χ�Ƶ�����
 *
 * ����˼�����Ա߽��ϵ�oΪ���,�����������ҵ������������ڵĵ㣬
 */
public class LC130 {
    public static void main(String[] args) {

    }

    /**
     * ����1��ʹ��dfs
     */
    static int row=0,col=0;
    //�ӱ߽��ϵ�ĳһ'O'��ʼ�ҵ����к������ڵ�'O',����ֵΪ'A'
    public static void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        if (board[x][y] == 'O'){
            board[x][y] = 'A';
            dfs(board, x + 1, y);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x, y - 1);
        }
    }

    public static void solve(char[][] board) {
        row = board.length;
        col = board[0].length;

        //�ӱ߽翪ʼ�����Ƿ����'O'
        for (int i = 0; i < row; i++) {
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        for (int i = 0; i < col; i++) {
            dfs(board,0,i);
            dfs(board,row-1,i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j]=='A'){
                    board[i][j]='O';
                }else if (board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    /**
     *����2 ʹ��bfs
     */
    public void solve1(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();

        /**
         *�����ڱ߽��ϵ����к��ʵĵ㶼���뵽������
         */
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
            }
            if (board[i][m - 1] == 'O') {
                queue.offer(new int[]{i, m - 1});
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
            }
            if (board[n - 1][i] == 'O') {
                queue.offer(new int[]{n - 1, i});
            }
        }
        //����BFS
        int [][] next = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0], y = node[1];
            board[x][y] = 'A';
            for (int i = 0; i < 4; i++) {
                int tx = x + next[i][0], ty = y + next[i][1];
                if (tx < 0 || ty < 0 || tx >= n || ty >= m || board[tx][ty] != 'O') {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
