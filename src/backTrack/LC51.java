package backTrack;

import java.util.*;

/**
 * @author zhxspacex
 * @date 2021/1/1 22:52
 */
/**
 *https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-by-leetcode-solution/
 * 利用行与列之间的关系判断是否在同一行或同一列或同一斜线上
 */
/**
 *解法1
 */
public class LC51 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(8));
    }

    //为什么使用set集合
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    /**
     *
     */
    public static void backtrack(List<List<String>> solutions, int[] queens,
                                 int n, int row, Set<Integer> columns,
                                 Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {//判断该列中是否已经放置了元素
                    continue;
                }
                int diagonal1 = row - i;
                //从左上到右下
                if (diagonals1.contains(diagonal1)) {//判断该点的行列值之差是否在diagonal1
                    // 1中，即该点所在斜线上是否已经放置了元素
                    continue;
                }
                int diagonal2 = row + i;
                //从右上到左下
                if (diagonals2.contains(diagonal2)) {//断该点的行列值之和是否在diagonal2
                    // 1中，即该点所在斜线上是否已经放置了元素
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    /**
     *生成对应的符合要求的地图
     */
    public static List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}

