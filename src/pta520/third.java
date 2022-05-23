package pta520;

import java.util.Scanner;

public class third {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sex = scan.nextInt();
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();

        int n = scan.nextInt();
        int [][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            if (sex != arr[i][0] && arr[i][1] >= a && arr[i][1] <= b && arr[i][2] >= c && arr[i][2] <= d) {
                System.out.println(arr[i][0]+" "+arr[i][1]+" "+arr[i][2]);
            }
        }

    }
}
