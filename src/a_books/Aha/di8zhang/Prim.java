package a_books.Aha.di8zhang;

import java.util.Scanner;

//最小生成树
//没有使用堆优化，适用于稠密图
public class Prim {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [][] e = new int[7][7];
        int [] dis = new int[7];
        int [] book = new int[7];
        int inf = Integer.MAX_VALUE;
        int count=0,sum=0;
        int n = scan.nextInt();
        int m = scan.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) e[i][j]=0;
                else e[i][j]=inf;
            }
        }

        for (int i = 1; i <= m; i++) {
            int t1 = scan.nextInt();
            int t2 = scan.nextInt();
            int t3 = scan.nextInt();
            e[t1][t2] = t3;
            e[t2][t1] = t3;
        }

        //初始化dis数组，这里是1号顶点到各个顶点的距离，因为当前是生成树中使用1号顶点
        for (int i = 1; i <= n; i++) {
            dis[i] = e[1][i];
        }

        //Prim核心
        book[1]=1;
        count++;
        while (count < n){
            int min = inf,j = 0;
            for (int i = 1; i <= n; i++) {
                if (book[i] == 0 && dis[i] < min){
                    min = dis[i];j=i;
                }
            }

            //为下一次找离生成树最近的点做准备
            book[j]=1;count++;sum+=dis[j];

            for (int i = 1; i <= n; i++) {
                if (book[i] == 0 && dis[i] > e[j][i])//dis[i] > e[j][i]注意：记录的是离生成树最近的点而
                    // 不是离某一点最近的点，但是j只能最新加入到生成树中点。
                    dis[i] = e[j][i];
            }
        }

        System.out.println(sum);
    }
}
