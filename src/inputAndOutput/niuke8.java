package inputAndOutput;

import java.util.Arrays;
import java.util.Scanner;

public class niuke8 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] data = new String[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = scan.next();
        }
        Arrays.sort(data);
        for (int i = 0; i < data.length; i++) {
            if (i != data.length-1) {
                System.out.print(data[i]+" ");
            }else {
                System.out.print(data[i]);
            }
        }
    }
}