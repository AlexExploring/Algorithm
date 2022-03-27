package UnionFind.Summary;

import java.util.Scanner;

/**
 *问题描述:
 * 给出区间[a, b]，区间之和为v。输入m组数据，每输入一组，判断此组条件是否与前面冲突，最后输出
 * 与前面冲突的数据的个数。比如先给出[1, 5]区间和为100，再给出区间[1, 2]的和为200，肯定有冲突。
 * 题解:
 * 本题是本节讲解的带权值并查集的直接应用。如果能想到可以把序列建模为并查集，就能直接套用模板了
 */
public class hdu3038_flag2 {
    static int maxn = 200010;
    static int [] s = new int[maxn];
    static int [] d = new int[maxn];
    static int ans = 0;
    static int n = 0,m = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        init();
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int v = scan.nextInt();
            merge(a,b,v);
        }
        System.out.println(ans);
    }

    public static void traverse(int n){
        for (int i = 1; i <= n; i++) {
            System.out.print(s[i]+" ");
        }
    }

    public static void traverse1(int n){
        for (int i = 1; i <= n; i++) {
            System.out.print(d[i]+" ");
        }
    }
    public static void init(){
        for(int i = 1; i < maxn; i++)
        {   s[i] = i;  }
    }

    public static int find(int x){
        if(x != s[x]) {
            int t = s[x];            //记录父结点
            s[x] = find(s[x]);   //路径压缩。递归最后返回的是根结点
            d[x] += d[t];            //权值更新为x到根节点的权值
        }
        return s[x];
    }

    public static void merge(int a,int b,int v){
        int roota = find(a), rootb = find(b);
        if(roota == rootb){
            System.out.println(roota+"  "+rootb);
            if(d[a] - d[b] != v)
                ans++;
        }
        else{
            s[roota] = rootb;    //合并
            d[roota] = d[b]- d[a] + v;
            System.out.println(d[roota]);
            traverse(n);
            System.out.println();
            traverse1(n);
        }
    }
}
