package a_books.Aha.di8zhang;
/**
 * 最小生成树*/
import java.util.Scanner;

public class Kruskal {
    static class edge{
        int u;
        int v;
        int w;
    }
    static edge [] e;
    static int [] f;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count=0,sum=0;
        int n = scan.nextInt();
        int m = scan.nextInt();
        e = new edge[m+1];
        f = new int[n+1];
        for (int i = 1; i <= m; i++) {
            e[i] = new edge();
            e[i].u = scan.nextInt();
            e[i].v = scan.nextInt();
            e[i].w = scan.nextInt();
        }

        quickSort(1,m);
        init(n);

        for (int i = 1; i <= m; i++) {
            if (merge(e[i].u,e[i].v) != 0){
                count++;
                sum+=e[i].w;
            }
            if (count == n-1)
                break;
        }

        System.out.print(sum);
    }

    private static void quickSort(int left,int right) {
        int i,j,temp;
        edge t;
        if (left > right)   //'='的取舍
            return;
        temp = e[left].w;
        i = left;
        j = right;
        while (i != j){
            while (e[j].w >= temp && i < j)
                j--;
            while (e[i].w <= temp && i < j)
                i++;
            if (i < j){
                t = e[i];
                e[i] = e[j];
                e[j] = t;
            }
        }
        //基准数归位
        t = e[left];
        e[left] = e[i];
        e[i] = t;

        quickSort(left,i-1);
        quickSort(i+1,right);
    }

    //合并两子集的函数
    private static int merge(int v, int u) {
        int t1 = getf(v);
        int t2 = getf(u);
        if (t1 != t2){
            //靠左原则，左边变成右边的子集，即把右边的集合，作为左边集合的子集和
            f[t2] = t1;
            return 1;
        }
        return 0;
    }

    //找爹的函数，不停的去找爹，直到找到祖宗为止，其实就是找最高领导人
    private static int getf(int v){
        if (f[v] == v)
            return v;
        else {
            f[v]=getf(f[v]);
            return f[v];
        }
    }

    private static void init(int n) {
        for (int i = 1; i <= n; i++) {
            f[i] = i;
        }
    }

}
