package a_books.Aha.di6zhang;

/**
 * @author zhxspacex
 * @date 2020/12/26 23:11
 */

import java.util.Scanner;

/**
 *多源最短路径
 */
public class FloydWarshall {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [][] e = new int[10][10];
        int n = scan.nextInt();
        int m = scan.nextInt();
        //初始化地图
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i==j) e[i][j]=0;
                else e[i][j] = Integer.MAX_VALUE;
            }
        }

        //读入边
        for (int i = 1; i <= m; i++) {
            int t1 = scan.nextInt();
            int t2 = scan.nextInt();
            e[t1][t2] = scan.nextInt();//为该边赋值
        }

        //算法核心
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (e[i][j]>e[i][k]+e[k][j])
                        e[i][j] = e[i][k]+e[k][j];
                }
            }
        }

        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= n;j++){
                System.out.print(e[i][j]+" ");
            }
            System.out.println();
        }
    }
}
