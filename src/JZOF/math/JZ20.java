package JZOF.math;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 表示数值的字符串
 */
public class JZ20 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        isNumber("  21.3E-5");
    }

    public static boolean isNumber(String s) {
        String t = s.trim();
        String [] data = t.split("e|E");

        int flag = 0;
        int pos_neg = 0;

        if (data.length==1){
            String t1 = data[0];
            int len = 0;
            while (len<t1.length()){
                if (t1.charAt(len)=='.') flag++;
                if (t1.charAt(len)=='-'|t1.charAt(len)=='+') pos_neg++;
            }
            if (flag>1||pos_neg>1) return false;
            if (pos_neg==1&&(t1.charAt(0)!='-'||t1.charAt(0)!='+')) return false;


        }
        return false;
    }
}
