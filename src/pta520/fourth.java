package pta520;

import java.util.Scanner;

public class fourth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int flag = 0;
        for (int i = 11; i <= m; i++) {
            for (int j = 55; j <= m; j++) {
                for (int k = 495; k <= m; k++) {

                    int t = lcm(i,j);
                    int femmu = lcm(t,k);
                    int fenzi = femmu/i+femmu/j+femmu/k;
                    if (3*femmu == n*fenzi) {
                        System.out.println(i+" "+j+" "+k);
                        flag = 1;
                        break;

                    }
                }
            }
        }

        if (flag == 0) System.out.println("No solution in (3, "+m+"].");
    }

    /**
     *求最小公倍数
     */
    public static int lcm(int a,int b){
        int t = gcd(a,b);
        return (a*b)/t;
    }

    /**
     *求最大公约数
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
