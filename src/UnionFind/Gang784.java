package UnionFind;

import java.util.Scanner;

/**
 *1920 年的芝加哥，出现了一群强盗。
 * 如果两个强盗遇上了，那么他们要么是朋友，要么是敌人。
 * 而且有一点是肯定的，就是：
 * 我朋友的朋友是我的朋友；
 * 我敌人的敌人也是我的朋友。
 * 两个强盗是同一团伙的条件是当且仅当他们是朋友。
 * 现在给你一些关于强盗们的信息，问你最多有多少个强盗团伙。
 *
 * 输入格式
 * 第一行包含整数 N，表示强盗的个数（从 1 编号到 N）。
 * 第二行包含整数 M，表示关于强盗的信息条数。
 * 接下来 M 行，每行可能是 F p q 或是 E p q，F 表示 p 和 q 是朋友，E 表示 p 和 q 是敌人。
 * 输入数据保证不会产生信息的矛盾。
 * 输出格式
 * 输出只有一行，表示最大可能的团伙数。
 * 数据范围
 * 2≤N≤1000,
 * 1≤M≤5000,
 * 1≤p,q≤N
 * 输入样例
 * 6
 * 4
 * E 1 4
 * F 3 5
 * F 4 6
 * E 1 2
 * 输出样例:
 * 3
 */
public class Gang784 {
    static int [] f = new int[10000];//集
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char ch;
        int n = scan.nextInt();
        int m = scan.nextInt();
        init(n*2);//对集f进行初始化
        int a,b,sum=0;
        //如果a和b是敌人，合并n+b和a，n+a和b
        //如果c和a是敌人，合并n+c和a，n+a和c
        //那么b和c就并在一起了
        //这样就符合了题目敌人的敌人是朋友的规则
        for (int i = 1; i <= m; i++) {
            ch = scan.next().charAt(0);
            a = scan.nextInt();
            b = scan.nextInt();
            if (ch == 'F'){
                merge(getf(a),getf(b));
                traverse(f);
            } else {
                merge(getf(a+n),getf(b));
                traverse(f);
                merge(getf(b+n),getf(a));
                traverse(f);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (f[i] == i) sum++;
        }
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
        System.out.println(v+"  "+f[v]);
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
