package a_books.Aha.di6zhang;

/**
 * @author zhxspacex
 * @date 2020/12/26 23:53
 */

import java.util.Scanner;

/**
 *单源最短路径
 *
 * 例如求 1号顶点到其余顶点的距离
 * 还需要一个辅助数组dis来存储1号顶点到其余各个顶点的初始路程.
 * 逐渐实现所有边的松弛
 */
public class Dijkstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [][] e = new int[10][10];
        int [] dis = new int[10];
        int [] book = new int[10];
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

        for (int i = 1;i <= n;i++){
            dis[i] = e[1][i];
        }

        for (int i = 1;i <= n;i++){
            book[i] = 0;
        }

        book[1] = 1;
        //算法核心
        for (int i = 1;i <= n;i++){

            //每次找到离1号顶点最近的点，然后以该顶点为中心进行扩展，
            // 最终得到1号顶点到其余所有点的最短路径
            int min = Integer.MAX_VALUE,u=0;
            for (int j = 1; j <= n; j++) {
                if (book[j] == 0 && dis[j] < min){
                    min = dis[j];
                    u=j;
                }
            }
            book[u]=1;
            for (int j = 1; j <= n; j++) {
                if (e[u][j]<Integer.MAX_VALUE){
                    if (dis[j]>dis[u]+e[u][j])
                        dis[j]=dis[u]+e[u][j];
                }
            }
        }

        for (int i = 1;i <= n;i++){
            System.out.print(dis[i]+" ");
        }
    }
}
