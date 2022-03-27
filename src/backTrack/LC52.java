package backTrack;

/**
 * @author zhxspacex
 * @date 2021/1/10 21:10
 */

import java.util.*;

/**
 *N皇后II
 */
public class LC52 {
    static int ans = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(solveNQueens2(n));
    }
    public static int solveNQueens(int n) {
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(n, 0, columns, diagonals1, diagonals2);
        return ans;
    }

    public static void backtrack(int n, int row, Set<Integer> columns,
                                 Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            ans++;
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
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    public static int solveNQueens1(int n) {
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        return backtrack1(n, 0, columns, diagonals1, diagonals2);
    }

    public static int backtrack1(int n, int row, Set<Integer> columns,
                                 Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count += backtrack1(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }

    /**
     *方法3 位运算
     */

    /**
     *
     */
    //记录每行的位置
    static int res = 0;
    static int [] chess;
    public static int solveNQueens2(int n) {
        chess = new int[n];
        dfs(0, n);
        return res1;
    }

    //index当前索引，n总数
    public static void dfs(int index, int n)
    {
        //找到结果
        if (index == n) {
            res1++;
            return;
        }
        for (chess[index] = 0; chess[index] < n; chess[index]++) {
            if (cheak(index)) {
                dfs(index + 1, n);
            }
        }

    }
    public static boolean cheak(int n) {
        //判断n和之前的棋子是否冲突
        for (int i = 0; i < n; i++) {
            //某两行选中的点在同一斜线上或某两行选择了同样的列
            if (n - i == Math.abs(chess[n] - chess[i]) || chess[i] == chess[n]) {
                return false;
            }
        }
        return true;
    }

    /**
     *利用对称性
     */
    static int res1 = 0;

    public static int solveNQueens3(int n) {
        int[] used = new int[n];
        int[] path = new int[n];
        Arrays.fill(path, -1);
        int flag = 0;
        for(int i=0; i<(n+1)/2; i++) { //仅需遍历一半！！！
            if(i==(n/2)) flag = res1; //n为奇数时，当遍历到中间时，记录一下之前有多少个res;n为偶数走不到这一步。
            used[i] = 1;
            path[0] = i;
            backTrace(used, i, 1, n, path);
            path[0] = -1;
            used[i] = 0;
        }
        if((n&1)==0) return res1 *2; //n为偶数时，直接是前一半结果乘2
        return flag*2+(res1 -flag);//n为奇数时，我们之前记录的flag乘2,加上以中间值为起点的时候回溯的结果(res-flag)

    }


    /**
     * @param used 标记某列是否已经使用的数组;
     * @param n 即n阶矩阵
     * @param
     */
    public static void backTrace(int[] used, int last, int row, int n, int[] path) {
        if(row==n) {
            res1++;
            return;
        }
        for(int i=0; i<n; i++) {
            if(used[i]==1) continue; //判断该列是否已经有过了
            if(i==last || (last>0 && i==last-1) || (last<n-1 && i==last+1)) continue; //判断竖向，斜向问题
            if(row>1) { //判断是否有跨行的斜向问题
                int j = row-2;
                for(; j>=0; j--) {
                    if( i-path[j] == row-j || path[j]-i == row-j) break;
                }
                if(j>=0) continue;
            }
            used[i] = 1;
            path[row] = i;
            backTrace(used, i, row+1, n, path);
            path[row] = -1;
            used[i] = 0;
        }
    }

    /**
     *方法6
     */

    /**
     * 记录某列是否已有皇后摆放
     */
    private boolean col[];

    /**
     * 记录某条正对角线（左上右下）是否已有皇后摆放（某条对角线对应的摆放位置为 x - y + n - 1）
     */
    private boolean dia1[];

    /**
     * 记录某条斜对角线（左下右上）是否已有皇后摆放（某条对角线对应的摆放位置为 x + y）
     */
    private boolean dia2[];

    public int totalNQueens(int n) {
        // 依然可以使用 51 号问题的解决思路，但问题是有没有更好的方法
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        return putQueen(n, 0);
    }

    /**
     * 递归回溯方式摆放皇后
     *
     * @param n     待摆放皇后个数
     * @param index 已摆放皇后个数
     */
    private int putQueen(int n, int index) {
        int res = 0;
        if (index == n) {
            return 1;
        }
        // 表示在 index 行的第 i 列尝试摆放皇后
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[i - index + n - 1] && !dia2[i + index]) {
                // 递归
                col[i] = true;
                dia1[i - index + n - 1] = true;
                dia2[i + index] = true;
                res += putQueen(n, index + 1);
                // 回溯
                col[i] = false;
                dia1[i - index + n - 1] = false;
                dia2[i + index] = false;
            }
        }
        return res;
    }

}
