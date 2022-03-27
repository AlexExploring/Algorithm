package a_books.algorithm_competition.nin.nin_Str_2;

import java.util.HashMap;
import java.util.Scanner;

/**
 *×Ö·û´®¹þÏ£
 *
 * hdu4821
 * hdu4080
 * hdu4622
 *
 */
public class hdu2648 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=0,m=0,p=0;
        String s = new String();
        HashMap<String,Integer> map = new HashMap();
        while (scan.hasNextInt()){
            int t = n = scan.nextInt();
            System.out.println("n="+n);
            while (t>0){
                s = scan.next();
                System.out.println("s="+s);
                t--;
            }
            m = scan.nextInt();
            System.out.println("¿ªÊ¼m="+m);
            while (m>0){
                System.out.println("m="+m);
                for (int i = 1; i <= n; i++) {
                    p = scan.nextInt();
                    s = scan.next();
                    map.put(s,p);
                }
                int rank = 1;
                for(String key:map.keySet()){
                    if (map.get(key)>map.get("memory")){
                        rank++;
                    }
                }
                System.out.println(rank);
                m--;
            }
        }
    }
}
