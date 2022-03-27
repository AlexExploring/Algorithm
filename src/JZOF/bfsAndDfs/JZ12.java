package JZOF.bfsAndDfs;

public class JZ12 {
    public boolean exist(char[][] board, String word) {
        int row = board.length,col = board[0].length;
        used = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!flag && board[i][j]==word.charAt(0)){
                    dfs(board,i,j,word,0);
                }
            }
        }
        return flag;
    }

    boolean flag = false;
    boolean [][] used;

    public void dfs(char [][] board,int x,int y,String word,int index){
        if (index==word.length()){
            flag=true;return;
        }else if (flag) return;
        else if (x > -1 && x < board.length && y > -1 && y < board[0].length){
            if(!used[x][y] && board[x][y] == word.charAt(index)){
                used[x][y] = true;
                dfs(board, x - 1, y, word, index + 1);
                dfs(board, x + 1, y, word, index + 1);
                dfs(board,  x, y - 1, word, index + 1);
                dfs(board,  x, y + 1, word, index + 1);
                used[x][y] = false;
            }
        }
    }
}
