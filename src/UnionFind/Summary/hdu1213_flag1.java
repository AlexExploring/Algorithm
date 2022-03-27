package UnionFind.Summary;

import java.util.Scanner;

/**
 * How many tables
 *
 * 普通并查集
 */
public class hdu1213_flag1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int n = 0,m = 0;
        while (t--!=0){
            n = scan.nextInt();
            m = scan.nextInt();
            init();
            for (int i = 1; i <= m; i++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                merge(x,y);
                traverse(n);
                System.out.println();
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (s[i]==i) ans++;
        }
        System.out.println(ans);
    }

    static int maxn = 1050;
    static int [] s = new int[maxn+1];

    public static void traverse(int n){
        for (int i = 1; i <= n; i++) {
            System.out.print(s[i]+" ");
        }
    }

    public static void init(){
        for(int i = 1; i <= maxn; i++)
        {   s[i] = i;  }
    }

    public static int find(int x){
        if(x != s[x]) {
            s[x] = find(s[x]);   //路径压缩。递归最后返回的是根结点
        }
        return s[x];
    }

    public static void merge(int x,int y){
        x = find(x);
        y = find(y);
        if (x!=y) s[x] = s[y];  //把x合并到y上

    }
}
