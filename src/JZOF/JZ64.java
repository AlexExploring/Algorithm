package JZOF;

import java.util.Scanner;

public class JZ64 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    }

    public int sumNums(int n) {
        //����&&�Ķ�·ЧӦ
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
