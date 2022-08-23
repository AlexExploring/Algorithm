package inputAndOutput;

import java.util.Scanner;

public class niuke6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextInt()) {
            int tem = 0,n = scan.nextInt();
            while (n-- > 0) {
                tem += scan.nextInt();
            }
            System.out.println(tem);
        }
    }
}
