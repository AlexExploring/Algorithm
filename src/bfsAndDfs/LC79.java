package bfsAndDfs;

/**
 * ��������  ֻ��Ҫһ������ֵ��Ϊ���
 *
 * dfs �� bfs
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
        //���ڷ�Χ��
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) return false;
        if (k == word.length()-1) return true;
        //��ֹ�ظ�����ͬһ��λ��
        board[i][j] = '\0';

        boolean result = search(board, word, i - 1, j, k + 1) || search(board, word, i + 1, j, k + 1)
                || search(board, word, i, j - 1, k + 1) || search(board, word, i, j + 1, k + 1);

        board[i][j] = word.charAt(k);

        return result;
    }

    public boolean exist1(char[][] board, String word) {
        int row = board.length,col = board[0].length;
        used = new boolean[row][col];

        //ֻҪboard��ĳһ���ַ���word�ĵ�һ���ַ���ȾͿ���Ϊ���������
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!flag && board[i][j]==word.charAt(0)){
                    dfs(board,i,j,word,0);
                }
            }
        }

        return flag;
    }

    private boolean flag = false;
    private boolean [][] used;

    public void dfs(char [][] board,int x,int y,String word,int index){
        if (index == word.length()){
            flag = true;
        }
        else if (flag) return;
        else if (x >= 0 && x < board.length && y >= 0 && y < board[0].length){
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
