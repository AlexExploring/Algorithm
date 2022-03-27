package JZOF.math;

import java.util.Arrays;
import java.util.Scanner;

public class JZ17 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] ans = printNumbers(scan.nextInt());
        System.out.println(Arrays.toString(ans));
    }

    /**
     *基础版 虽然本身题目的要求不高，但是面试的时候，一定是需要考虑大数的情况的
     */
    public static int[] printNumbers(int n) {
        int max = (int)Math.pow(10,n)-1;
        int [] ans = new int[max];
        for (int i = 0; i < max; i++) {
            ans[i] = i+1;
        }
        return ans;
    }
}
