package inputAndOutput;

import java.util.Scanner;

public class niuke4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int n = scan.nextInt();
            if (n == 0) break;

            int tem = 0;
            while (n-- > 0) {
                tem += scan.nextInt();
            }
            System.out.println(tem);
        }
    }
}
