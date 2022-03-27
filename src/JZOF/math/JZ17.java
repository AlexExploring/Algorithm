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
     *������ ��Ȼ������Ŀ��Ҫ�󲻸ߣ��������Ե�ʱ��һ������Ҫ���Ǵ����������
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
