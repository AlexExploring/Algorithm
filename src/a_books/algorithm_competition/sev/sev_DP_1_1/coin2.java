package a_books.algorithm_competition.sev.sev_DP_1_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *打印最少的硬币组合
 */
public class coin2 {
    static int money = 2000;//最大金额
    static int value = 5;//5种硬币
    static int [] type = {1,5,10,25,50};//5种面额
    static int [] Min = new int[money];
    static int [] Min_path = {0};

    public static void main(String[] args) {
        solve();
        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
        System.out.println(Min[s]);
        System.out.println();
        print_ans(s);
    }
    
    public static void solve(){
        Arrays.fill(Min,Integer.MAX_VALUE);
        Min[0]=0;
        for (int i = 0; i < value; i++) {
            for (int j = type[i]; j < money; j++) {
                if (Min[j]>Min[j-type[i]]+1){
                    Min_path[j] = type[i];
                    Min[j] = Min[j-type[i]]+1;
                }
            }
        }
    }

    public static void print_ans(int s){
        while (s>0){
            System.out.println(Min_path[s]+" ");
            s -= Min_path[s];
        }
    }

}
