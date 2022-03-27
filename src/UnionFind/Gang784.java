package UnionFind;

import java.util.Scanner;

/**
 *1920 ���֥�Ӹ磬������һȺǿ����
 * �������ǿ�������ˣ���ô����Ҫô�����ѣ�Ҫô�ǵ��ˡ�
 * ������һ���ǿ϶��ģ����ǣ�
 * �����ѵ��������ҵ����ѣ�
 * �ҵ��˵ĵ���Ҳ���ҵ����ѡ�
 * ����ǿ����ͬһ�Ż�������ǵ��ҽ������������ѡ�
 * ���ڸ���һЩ����ǿ���ǵ���Ϣ����������ж��ٸ�ǿ���Ż
 *
 * �����ʽ
 * ��һ�а������� N����ʾǿ���ĸ������� 1 ��ŵ� N����
 * �ڶ��а������� M����ʾ����ǿ������Ϣ������
 * ������ M �У�ÿ�п����� F p q ���� E p q��F ��ʾ p �� q �����ѣ�E ��ʾ p �� q �ǵ��ˡ�
 * �������ݱ�֤���������Ϣ��ì�ܡ�
 * �����ʽ
 * ���ֻ��һ�У���ʾ�����ܵ��Ż�����
 * ���ݷ�Χ
 * 2��N��1000,
 * 1��M��5000,
 * 1��p,q��N
 * ��������
 * 6
 * 4
 * E 1 4
 * F 3 5
 * F 4 6
 * E 1 2
 * �������:
 * 3
 */
public class Gang784 {
    static int [] f = new int[10000];//��
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char ch;
        int n = scan.nextInt();
        int m = scan.nextInt();
        init(n*2);//�Լ�f���г�ʼ��
        int a,b,sum=0;
        //���a��b�ǵ��ˣ��ϲ�n+b��a��n+a��b
        //���c��a�ǵ��ˣ��ϲ�n+c��a��n+a��c
        //��ôb��c�Ͳ���һ����
        //�����ͷ�������Ŀ���˵ĵ��������ѵĹ���
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

    //��
    public static int getf(int v){
        System.out.println(v+"  "+f[v]);
        if (f[v] != v)//�������ǰ���ڵ㲻�����Լ�
            f[v] = getf(f[v]);//������ǰ���ڵ�����Ϊ��ǰ���ڵ�Ϊ�Լ��ĵ㣩�ĵ㣬ֱ�Ӹ�����ڵ�
        return f[v];
    }

    //��
    private static void merge(int a, int b){
        f[a] = b;//������ͬһ�����ڵ�
    }

    //��ʼ��
    private static void init(int n) {
        for (int i = 1; i <= n; i++) {
            f[i] = i;
        }
    }
}
