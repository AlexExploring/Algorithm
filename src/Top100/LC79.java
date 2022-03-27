package Top100;

/**
 * 单词搜索  只需要一个布尔值作为结果
 *
 * dfs 或 bfs
 */
public class LC79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board,word,i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean search(char [][] board,String word,int i,int j,int k){
        if (k >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) return false;
        board[i][j] += 256;
        boolean result = search(board, word, i - 1, j, k + 1) || search(board, word, i + 1, j, k + 1)
                || search(board, word, i, j - 1, k + 1) || search(board, word, i, j + 1, k + 1);
        board[i][j] -= 256;
        return result;
    }
}
