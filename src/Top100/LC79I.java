package Top100;

/**
 *  dfs一定会使用递归
 *
 *  和JZ12一样
 */
public class LC79I {
    public boolean exist(char[][] board, String word) {
        boolean [][] visited =  new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board,visited,word,i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean search(char [][] board,boolean [][] visited,String word,int i,int j,int k){
        if (board[i][j]!=word.charAt(k)){
            return false;
        }else if (k==word.length()-1){
            return true;
        }

        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;

        for (int[] dir : directions) {
            int newi = i+dir[0],newj = j+dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    if (search(board, visited,word,newi, newj, k + 1)) {
                        result = true;
                        break;
                    }
                }
            }
        }

        visited[i][j] = false;
        return result;
    }
}
