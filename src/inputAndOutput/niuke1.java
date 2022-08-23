package inputAndOutput;

import java.util.Scanner;

public class niuke1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long a,b;
        while (scan.hasNextLong()) {
            a = scan.nextLong();
            b = scan.nextLong();
            System.out.println(a+b);
        }
    }
}
