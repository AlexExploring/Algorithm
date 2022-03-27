package BinarySearch.templates;

import java.util.Scanner;

/**
 *·ÖÇÉ¿ËÁ¦
 */
public class DivideChocolate1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int [] h = new int[n];
        int [] w = new int[n];

        for (int i = 0; i < n; i++) {
            h[i] = scan.nextInt();
            w[i] = scan.nextInt();
        }

        int l = 0,r = 100010;
        while (l<r){
            int mid = l+r+1>>1;
            if (getSum(h,w,n,mid)>=k) l = mid;
            else r = mid-1;
        }
        System.out.println(l);
    }

    public static int getSum(int [] h,int[] w,int n,int mid){
        int sum = 0;
        for (int j = 0; j < n; j++) {
            if (h[j]/mid>0&&w[j]/mid>0){
                sum+=(h[j]/mid)*(w[j]/mid);
            }
        }
        return sum;
    }
}
