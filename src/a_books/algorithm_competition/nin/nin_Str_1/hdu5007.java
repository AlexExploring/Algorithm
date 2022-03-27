package a_books.algorithm_competition.nin.nin_Str_1;

import java.util.Scanner;

/**
 *×Ó´®²éÕÒ
 */
public class hdu5007 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = new String();
        while (scan.hasNextLine()){
            s = scan.nextLine();
            System.out.println(s.indexOf("zhxljq"));
            System.out.println(s.substring(s.indexOf("zhxljq"),s.indexOf("zhxljq")+6));
        }
    }
}
