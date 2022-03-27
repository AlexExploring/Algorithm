package backpack;

import java.util.Scanner;

/**
 *3.��ȫ�������� �Ż�
 */
public class CompleteBackpack_1 {
    static int N = 1010;
    static int [] v = new int[N];
    static int [] w = new int[N];
    static int [] f = new int[N];
    /**
     *n ��Ʒ����
     *m ��������
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        for(int i = 1 ; i <= n ;i ++)
        {
            v[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }

        for(int i = 1 ; i<=n ;i++){
            for(int j = v[i] ; j<=m ;j++) {
                f[j] = Math.max(f[j],f[j-v[i]]+w[i]);
            }
        }
        System.out.println(f[m]);
    }
}
