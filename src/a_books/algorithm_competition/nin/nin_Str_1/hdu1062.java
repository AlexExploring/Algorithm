package a_books.algorithm_competition.nin.nin_Str_1;

import java.util.Scanner;

/**
 *×Ö·û´®·´×ª
 */
public class hdu1062 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuffer s;
        String t = new String();
        while (scan.hasNextLine()){
            t = scan.nextLine();
            s = new StringBuffer(t);
            System.out.println(s.reverse());
        }
    }
}
