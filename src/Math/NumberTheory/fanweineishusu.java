package Math.NumberTheory;

import java.util.Scanner;

//给定范围内的素数
//一个质数的倍数一定是合数
//进行大数运算的时候一定要注意数表示的范围，
public class fanweineishusu {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int end = scan.nextInt();
        int [] st = new int[end+1];
        for(int i = 2; i <= end; i++){
            for(int j = 2; j <= i / j; j++){//试除法
                if(i % j == 0){
                    st[i] = 1; // 合数，标记为1
                }
            }
        }

        for (int i = 2; i <= end; i++) {
            if (st[i]==0)
                System.out.print("st[i]="+i+"  ");
        }
    }
}
