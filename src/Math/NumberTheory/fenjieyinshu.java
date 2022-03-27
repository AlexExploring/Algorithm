package Math.NumberTheory;

import java.util.Scanner;

//分解因数
public class fenjieyinshu {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        prime(n);
    }

    public static void prime(int n){
        for(int i = 2; i <= n / i; i++){
            int a = 0, b = 0;

            while(n % i == 0){
                a = i;
                n /= i;
                b++;
            }
            if(b > 0)
                System.out.println(a + " " + b);
        }
        if(n > 1) System.out.println(n + " " + 1);
    }

}
