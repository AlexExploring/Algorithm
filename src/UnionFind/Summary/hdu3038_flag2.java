package UnionFind.Summary;

import java.util.Scanner;

/**
 *��������:
 * ��������[a, b]������֮��Ϊv������m�����ݣ�ÿ����һ�飬�жϴ��������Ƿ���ǰ���ͻ��������
 * ��ǰ���ͻ�����ݵĸ����������ȸ���[1, 5]�����Ϊ100���ٸ�������[1, 2]�ĺ�Ϊ200���϶��г�ͻ��
 * ���:
 * �����Ǳ��ڽ���Ĵ�Ȩֵ���鼯��ֱ��Ӧ�á�������뵽���԰����н�ģΪ���鼯������ֱ������ģ����
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
            int t = s[x];            //��¼�����
            s[x] = find(s[x]);   //·��ѹ�����ݹ���󷵻ص��Ǹ����
            d[x] += d[t];            //Ȩֵ����Ϊx�����ڵ��Ȩֵ
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
            s[roota] = rootb;    //�ϲ�
            d[roota] = d[b]- d[a] + v;
            System.out.println(d[roota]);
            traverse(n);
            System.out.println();
            traverse1(n);
        }
    }
}
