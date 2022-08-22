package bishi.meituan1;

import java.util.Scanner;

public class fifth {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n+1];
        for (int i = 1;i <= n; i++) {
            array[i] = scan.nextInt();
        }

        System.out.println(new fifth().maxMoney(1,n,array));
    }

    public int maxMoney(int k, int n, int[] a) {
        int left,right;
        if (2*k <= n) left = maxMoney(2*k,n,a);
        else left = 0;
        if (2*k+1 <= n) right = maxMoney(2*k+1,n,a);
        else right = 0;

        return Math.max(left,right) + a[k];
    }
}
