package inputAndOutput;

import java.util.Scanner;

public class niuke2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a,b,n = scan.nextInt();
        while (n-- > 0) {
            a = scan.nextInt();
            b = scan.nextInt();
            System.out.println(a+b);
        }
    }
}
