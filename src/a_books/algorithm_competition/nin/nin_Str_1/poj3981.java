package a_books.algorithm_competition.nin.nin_Str_1;

import java.util.Scanner;

/**
 *poj3981
 * ×Ö·û´®Ìæ»»
 */
public class poj3981 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s  = new String();
        while (scan.hasNextLine()){
            s = scan.nextLine();
            System.out.println(s.replaceAll("you","we"));
        }
    }
}