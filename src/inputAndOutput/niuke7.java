package inputAndOutput;

import java.util.*;

public class niuke7 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String[] data = scan.nextLine().split(" ");
            int tem =0;
            for (String num : data) {
                tem += Integer.parseInt(num);
            }
            System.out.println(tem);
        }
    }
}