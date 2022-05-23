package pta520;

import java.util.Scanner;

public class second {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        if (m == (n*k)) System.out.println("zheng hao mei ren "+k+"!");
        else if (m > (n*k)) System.out.println("hai sheng "+(m-(n*k))+"!");
        else System.out.println("hai cha "+((n*k)-m)+"!");
    }
}
