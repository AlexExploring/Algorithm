package backpack;

import java.util.Scanner;

/**
 *多重背包问题
 *题解链接：https://www.acwing.com/solution/content/13873/
 * 法一:一个基本思路是，将此问题转换为01背包求解！
 * 比如物品1有3件，每件价值为2，我们不妨创建3个物品1，存在数组v和数组w中
 * 最终更新一下总物品数n即可，然后套用01背包问题进行求解。
 */
public class Multi_Backpack1 {

    /**
     * n,m分别表示数据条数和背包容积
     *a,b分别表示物品的体积和价值
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
                dp[j]=Math.max(dp[j-a[i]]+b[i],dp[j]);//直接套01背包的板子
        System.out.println(dp[m]);
    }
}
