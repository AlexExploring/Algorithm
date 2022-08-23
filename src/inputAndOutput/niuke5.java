package inputAndOutput;

import java.util.Scanner;

public class niuke5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int tem = 0,m = scan.nextInt();
            while (m-- > 0) {
                tem += scan.nextInt();
            }
            System.out.println(tem);
        }
    }
}
