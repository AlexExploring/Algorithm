package inputAndOutput;

import java.util.Arrays;
import java.util.Scanner;

public class niuke10 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] data = scan.next().split(",");
            Arrays.sort(data);
            for (int i = 0; i < data.length; i++) {
                if (i != data.length-1) {
                    System.out.print(data[i]+",");
                }else {
                    System.out.print(data[i]);
                }
            }
            System.out.println();
        }
    }
}