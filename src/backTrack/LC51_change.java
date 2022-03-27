package backTrack;

/**
 * @author zhxspacex
 * @date 2021/1/1 23:40
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *2n皇后
 */
public class LC51_change {
    static int ans=0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [][] map = new int[8][8];
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        System.out.println(solve2NQueens(n, map, 2));
    }
    public static int solve2NQueens(int n,int [][] map,int xQueen) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(map,n,xQueen,0, columns, diagonals1, diagonals2);
        return ans;
    }

    public static void backtrack(int [][] map, int n,int xQueen, int row,
                                 Set<Integer> columns, Set<Integer> diagonals1,
                                 Set<Integer> diagonals2) {
        if (row == n) {
           if (xQueen==2) solve2NQueens(n,map,3);
           else ans++;
        } else {
            for (int i = 0; i < n; i++) {
                if (map[row][i] != 1) continue;//1表示这个是能放皇后的空位，
                //判断该点是否可以放一个皇后
                if (columns.contains(i)) {//判断该列中是否已经放置了元素
                    continue;
                }
                int diagonal1 = row - i;
                //方向一的斜线为从左上到右下方向，同一条斜线上的每个位置满足行下标与列下标之差相等
                if (diagonals1.contains(diagonal1)) {//判断该点的行列值之差是否在diagonal1
                    // 1中，即该点所在斜线上是否已经放置了元素
                    continue;
                }
                int diagonal2 = row + i;
                //方向二的斜线为从右上到左下方向，同一条斜线上的每个位置满足行下标与列下标之和相等
                if (diagonals2.contains(diagonal2)) {//断该点的行列值之和是否在diagonal2
                    // 1中，即该点所在斜线上是否已经放置了元素
                    continue;
                }
                map[row][i] = xQueen;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(map,n, xQueen,row + 1, columns, diagonals1, diagonals2);
                map[row][i] = 1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }
}
