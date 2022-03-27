package UnionFind;

import java.util.Scanner;

public class NetworkAnalysis2069_1 {
    //��dis��ʾ�˽ڵ�����ڵ�Ĳ�ֵ�� ��value������¼���ڵ��ֵ��ÿ�δ�ֵ�����ڵ㸳ֵ��
    //�������value��dis֮��Ĺ�ϵ���õ���ȷ�Ľ��
    static int maxn = 10010;
    static int [] f = new int[maxn];
    static int [] dis = new int[maxn];
    static int [] value = new int[maxn];
    static int N = 0;

    //��Ȩֵ�Ĳ��鼯��·��ѹ��
    public static int find(int a)
    {
        if (f[a] != a) {
            int temp = f[a];
            f[a] = find(f[a]);
            dis[a] += dis[temp];
        }
        return f[a];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        N = n;
        int m = scan.nextInt();
        for (int i = 1; i <= n; i++) f[i]=i;
        int flag = 0,a = 0,b = 0,fa = 0,fb = 0;
        for (int i = 0 ; i < m; i++) {
            flag = scan.nextInt();
            if (flag == 1) {
                a = scan.nextInt();
                b = scan.nextInt();
                fa = find(a);
                fb = find(b);
                if (fa != fb) { //�ϲ�
                    f[fa] = fb;
                    dis[fa] = value[fa] - value[fb];
                }
            }else {
                a = scan.nextInt();
                b = scan.nextInt();
                fa = find(a);//�ҵ����ڵ�
                value[fa] += b;//���¸��ڵ��ֵ
            }
            traverse(f,n);
            traverse(dis,n);
            traverse(value,n);
            System.out.println("...................");
        }

        for (int i = 1; i <= n; i++) System.out.println(value[find(i)] + dis[i]);
    }

    public static void traverse(int [] t,int n){
        for (int i = 1; i <= n; i++) {
            System.out.print(t[i]+" ");
        }
        System.out.println();
    }
}
