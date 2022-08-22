package bishi.meituan1;

import java.util.Scanner;

public class fourth {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if (a[i] == 3*a[j]-a[k]) {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
