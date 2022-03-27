package backpack;

import java.util.Scanner;

/**
 *数据范围太大，直接转化为0/1问题会超时，使用二进制优化来降低时间复杂度
 *
 * 题解：https://www.acwing.com/solution/content/20115/
 */
public class Multi_Backpack2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int [] v = new int[12010];
        int [] w = new int[12010];
        int [] dp = new int[2010];

        int cnt = 0; //分组的组别
        for(int i = 1;i <= n;i ++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int s = scan.nextInt();
            int k = 1; // 组别里面的个数
            while(k<=s)
            {
                cnt ++ ; //组别先增加
                v[cnt] = a * k ; //整体体积
                w[cnt] = b * k; // 整体价值
                s -= k; // s要减小
                k *= 2; // 组别里的个数增加
            }
            //剩余的一组
            if(s>0)
            {
                cnt ++ ;
                v[cnt] = a*s;
                w[cnt] = b*s;
            }

        }
        n = cnt ; //枚举次数正式由个数变成组别数

        //01背包一维优化
        for(int i = 1;i <= n ;i ++)
            for(int j = m ;j >= v[i];j--)
                dp[j] = Math.max(dp[j],dp[j-v[i]] + w[i]);

        System.out.println(dp[m]);
    }
}
