package backpack;

import java.util.Scanner;

/**
 *���ر�������
 *������ӣ�https://www.acwing.com/solution/content/13873/
 * ��һ:һ������˼·�ǣ���������ת��Ϊ01������⣡
 * ������Ʒ1��3����ÿ����ֵΪ2�����ǲ�������3����Ʒ1����������v������w��
 * ���ո���һ������Ʒ��n���ɣ�Ȼ������01�������������⡣
 */
public class Multi_Backpack1 {

    /**
     * n,m�ֱ��ʾ���������ͱ����ݻ�
     *a,b�ֱ��ʾ��Ʒ������ͼ�ֵ
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int total=0,n=0,m=0,w=0,v=0,s=0;
        int [] dp = new int[10005];
        int [] a = new int[10005];
        int [] b = new int[10005];
        n = scan.nextInt();
        m = scan.nextInt();
        while (--n>=0){
            v = scan.nextInt();
            w = scan.nextInt();
            s = scan.nextInt();
            while (--s>=0){
                a[++total]=v;
                b[total]=w;
            }
        }
        for(int i=1;i<=total;i++)
            for(int j=m;j>=a[i];j--)//s
                dp[j]=Math.max(dp[j-a[i]]+b[i],dp[j]);//ֱ����01�����İ���
        System.out.println(dp[m]);
    }
}
