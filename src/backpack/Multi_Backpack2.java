package backpack;

import java.util.Scanner;

/**
 *���ݷ�Χ̫��ֱ��ת��Ϊ0/1����ᳬʱ��ʹ�ö������Ż�������ʱ�临�Ӷ�
 *
 * ��⣺https://www.acwing.com/solution/content/20115/
 */
public class Multi_Backpack2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [] v = new int[12010];
        int [] w = new int[12010];
        int [] dp = new int[2010];

        int cnt = 0; //��������
        for(int i = 1;i <= n;i ++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int s = scan.nextInt();
            int k = 1; // �������ĸ���
            while(k<=s)
            {
                cnt ++ ; //���������
                v[cnt] = a * k ; //�������
                w[cnt] = b * k; // �����ֵ
                s -= k; // sҪ��С
                k *= 2; // �����ĸ�������
            }
            //ʣ���һ��
            if(s>0)
            {
                cnt ++ ;
                v[cnt] = a*s;
                w[cnt] = b*s;
            }

        }
        n = cnt ; //ö�ٴ�����ʽ�ɸ�����������

        //01����һά�Ż�
        for(int i = 1;i <= n ;i ++)
            for(int j = m ;j >= v[i];j--)
                dp[j] = Math.max(dp[j],dp[j-v[i]] + w[i]);

        System.out.println(dp[m]);
    }
}
