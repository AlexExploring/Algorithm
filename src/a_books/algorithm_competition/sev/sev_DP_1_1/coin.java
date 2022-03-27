package a_books.algorithm_competition.sev.sev_DP_1_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *硬币问题
 * 有n种硬币，面值分别为v1，v2，...vn数量无限，输入非负整数s选用硬币，使其和为s，要求输出最少的硬币组合
 */
public class coin {
    static int money = 20000;//最大金额
    static int value = 5;//5种硬币
    static int [] type = {1,5,10,25,50};//5种面额
    static int [] Min = new int[money];

    public static void main(String[] args) {
        solve();
        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        System.out.println(Min[s]);
    }

    public static void solve(){
        Arrays.fill(Min,Integer.MAX_VALUE);
        Min[0]=0;
        for (int i = 0; i < value; i++) {
            for (int j = type[i]; j < money; j++) {
                Min[j] = Math.min(Min[j], Min[j-type[i]]+1);
            }
        }
    }
}
