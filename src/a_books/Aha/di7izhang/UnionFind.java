package a_books.Aha.di7izhang;

import java.util.Arrays;
import java.util.Scanner;

/**
 *找有几个独立团伙
 *
 * 并查集：通过一个一维数组来实现，其本质是维护一个森林。刚开始的时候
 * ，森林的每一个点都是孤立的，也可以理解为每个点就是一颗只有一个节点的树
 * 之后通过一些条件，主键将这些树合并成一些大树。。。
 *
 * 这个例子只能针对重关系 要么一伙，要么不一伙
 */

//10 9
//1 2
//3 4
//5 2
//4 6
//2 6
//8 7
//9 7
//1 6
//2 4
    //2 6 4 6 2 6 7 7 7 10
    //6 6 4 6 2 6 7 7 7 10
public class UnionFind {
    static int [] f;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = "asdfas";
        int x,y,sum=0;
        int n = scan.nextInt();
        int m = scan.nextInt();
        f = new int[n+1];
        init(n);//先将所有人初始化为n个独立的个体
        for (int i = 1; i <= m; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            merge(x,y);//合并，
            System.out.println(Arrays.toString(f));
        }

        for (int i = 1; i <= n; i++) {
            if (f[i] == i)
                sum++;
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(f[i]+" ");
        }
        System.out.println(sum);
    }

    //初始化
    private static void init(int n) {
        for (int i = 1; i <= n; i++) {
            f[i] = i;
        }
    }

    //合并两子集的函数
    private static void merge(int v, int u) {
        int t1 = getf(v);
        int t2 = getf(u);
        if (t1 != t2){//不属于同一个团伙则合并
            //靠左原则，左边变成右边的子集，即把右边的集合，作为左边集合的子集和
            f[t2] = t1;
        }
    }

    //找爹的函数，不停的去找爹，直到找到祖宗为止，其实就是找最高领导人
    private static int getf(int v){
        if (f[v] != v){
            //如果它的前驱节点是它自己
            f[v]=getf(f[v]); //访问它的前驱节点，一直找到前驱节点为该前驱节点自己的点
        }
         return f[v];
    }

    public static void merge1(int v,int u){
        f[getf1(u)] = getf1(v);//靠左原则
    }

    private static int getf1(int v){
        while (f[v] != v)//如果该点的前驱节点不是自己，直到找到为止
            v = f[v];
        return v;
    }

    public static void merge2(int v,int u){
        f[zip(v)] = zip(u);//靠左原则 ,使v为u的为前驱节点
    }

    public static int zip(int v){
        if (f[v] != v)//如果它的前驱节点不是他自己
            f[v] = getf1(f[v]);//将它的前驱节点设置为（前驱节点为自己的点）的点，直接跟随根节点
        return v;
    }

    public static void merge3(int v,int u){
        f[getf2(v)] = f[u]; //交换顺序之后
    }

    public static int getf2(int v){
        if (f[v] != v)
            f[v] = getf2(f[v]);
        return v;
    }
}
