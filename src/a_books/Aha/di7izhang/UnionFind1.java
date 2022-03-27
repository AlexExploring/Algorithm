package a_books.Aha.di7izhang;

import java.util.Scanner;

/**
 * 题目描述
 * 给定 n 个人，他们之间有两个种关系，朋友与敌对。可以肯定的是：
 *
 * 与我的朋友是朋友的人是我的朋友
 * 与我敌对的人有敌对关系的人是我的朋友
 * 现在这 n 个人进行组团，两个人在一个团队内当且仅当他们是朋友。
 *
 * 求最多的团体数。
 *
 * 输入格式
 * 第一行一个整数 n,n 代表人数。
 * 第二行一个整数 m,m 代表每个人之间的关系。
 * 接下来 m 行每行一个字符 optopt 与两个整数 p,q,
 *
 * 如果 optopt 为 F 代表 p 与 q 为朋友。
 * 如果 optopt 为 E 代表 p 与 q 为敌人。
 * 输出格式
 * 一行一个整数代表最多的团体数。
 *
 * 输入输出样例
 * 输入 #1复制
 *6
 *4
 *E 1 4
 *F 3 5
 *F 4 6
 *E 1 2
 * 输出 #1复制
 * 3
 * 说明/提示
 * 对于 100\%100% 的数据，2 \le n \le 10002≤n≤1000，1 \le m \le 50001≤m≤5000，1 \le p,q \le n1≤p,q≤n。*/
public class UnionFind1 {
    static int [] f = new int[1000];//集
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char ch;
        int n = scan.nextInt();
        int m = scan.nextInt();
        init(n*2);//对集f进行初始化
        int a,b,sum=0;
        for (int i = 1; i <= m; i++) {
            ch = scan.next().charAt(0);
            a = scan.nextInt();
            b = scan.nextInt();
            if (ch == 'F'){
                System.out.println(getf(a)+"   "+getf(b));
                merge(getf(a),getf(b));
                traverse(f);
            }

            else {
                System.out.println(getf(a+n)+"   "+getf(b));
                merge(getf(a+n),getf(b));
                traverse(f);
                System.out.println(getf(b+n)+"   "+getf(a));
                merge(getf(b+n),getf(a));
                traverse(f);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (f[i] == i) sum++;
        }

        for (int i = 1; i <= 12; i++) {
            System.out.print(f[i]+"  ");
        }

        System.out.println();
        System.out.println(sum);
    }

    public static void traverse(int [] f){
        for (int i = 1; i <= 12; i++) {
            System.out.print(f[i]+"  ");
        }
        System.out.println();
    }

    //查
    public static int getf(int v){
        if (f[v] != v)//如果它的前驱节点不是他自己
            f[v] = getf(f[v]);//将它的前驱节点设置为（前驱节点为自己的点）的点，直接跟随根节点
        return f[v];
    }

    //并
    private static void merge(int a, int b){
        f[a] = b;//归属于同一个根节点
    }

    //初始化
    private static void init(int n) {
        for (int i = 1; i <= n; i++) {
            f[i] = i;
        }
    }
}
