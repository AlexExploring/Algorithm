package JZOF.bfsAndDfs;


/**
 *耗时1 ms
 *
 * 这里数据范围较小，使用dfs更快
 */
public class JZ13_3 {
    private boolean[][] board;
    private int ans = 0;

    public int movingCount(int m, int n, int k) {
        board = new boolean[m][n];
        dfs(0, 0, k, m, n);
        return ans;
    }

    public void dfs(int x, int y, int k, int m, int n){
        if(x < 0 || x >= m || y < 0 || y >= n || true == board[x][y]){
            return;
        }
        int tx = x,ty = y;
        if(util(tx,ty) > k){
            return;
        }else{
            ans++;
            board[x][y] = true;
            dfs(x, y + 1, k, m, n);
            dfs(x + 1, y, k, m, n);
        }
    }

    public int util(int x,int y){
        int sum = 0;
        while (x!=0){
            sum += (x%10);x/=10;
        }
        while (y!=0){
            sum += (y%10);y/=10;
        }
        return sum;
    }
}
