package a_books.Aha.di8zhang;

import java.util.Scanner;

//二分图最大匹配
//匈牙利算法  找增广路径的算法
public class HungarianAlgorithm {
    static int [][] e = new int[101][101];  //存储边
    static int [] match  = new int[101];   //记录是否配对
    static int [] book = new int[101];   //记录点是否已经被匹配过
    static int n,m;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t1,t2,sum=0;
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 1; i <= m; i++) {
            t1 = scan.nextInt();
            t2 = scan.nextInt();
            e[t1][t2]=1;
            e[t2][t1]=1;
        }

        for (int i = 1; i <= n; i++){
            match[i] = 0;
        }

        System.out.println(prim());
    }

    public static int prim(){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) book[j] = 0;
            if (dfs(i)) sum++;
        }
        return sum;
    }

    public static boolean dfs(int u){
        System.out.println("调用成功u="+u);
        for (int i = 1; i <= n; i++) {
            System.out.println(u+"  "+i+"准备匹配");
            if (book[i] == 0 && e[u][i] == 1){
                book[i] = 1;
                System.out.println("dafs");
                System.out.println("i="+i);
                if (match[i] == 0 || dfs(match[i])){
                    match[i] = u;
                    match[u] = i;
                    for (int j = 1; j <= n; j++) {
                        System.out.print(match[j]+" ");
                    }
                    System.out.println();
                    return true;
                }
            }
        }
        return false;
    }
}
