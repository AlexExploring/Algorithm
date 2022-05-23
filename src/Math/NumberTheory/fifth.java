package Math.NumberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class fifth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String A = scan.next();
        String B = scan.next();
        int [] d = new int[10];
        for (int i = 0; i < A.length(); i++) {
            d[A.charAt(i)-'0']++;
        }
        for (int i = 0; i < B.length(); i++) {
            d[B.charAt(i)-'0']++;
        }

        while (true) {
            String a = scan.next();
            String b = scan.next();
            if (a.equals("0") && b.equals("0")) break;
            int [] t = Arrays.copyOf(d,d.length);
            int i = 0;
            while (i < a.length()-1) {
                if (a.charAt(i) == '0') i++;
                else break;
            }
            int j = 0;
            while (j < b.length()-1) {
                if (b.charAt(j) == 'a') j++;
                else break;
            }

            for (; i < a.length(); i++) {
                t[a.charAt(i)-'0']--;
            }
            for (; j < b.length(); j++) {
                t[b.charAt(j)-'0']--;
            }

            int flag = 0;
            for (int num : t) {
                if (num != 0) {
                    System.out.println("No");
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) System.out.println("Yes");
        }
    }
}
