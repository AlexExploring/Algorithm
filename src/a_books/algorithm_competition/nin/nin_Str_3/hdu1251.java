package a_books.algorithm_competition.nin.nin_Str_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *×ÖµäÊ÷
 */
public class hdu1251 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        String s = new String();

        while (!(s=scan.nextLine()).equals("")){
            StringBuilder builder = new StringBuilder(s);
            int len = s.length();
            if (len==0) break;
            while (len>0){
                if (map.get(new String(builder))==null){
                    map.put(new String(builder),1);
                }else {
                    System.out.println("¼ÓÒ»");
                    map.put(new String(builder),map.get(new String(builder))+1);
                }
                builder.deleteCharAt(builder.length()-1);
                len--;
            }
        }

        Set<Map.Entry<String,Integer>> entrySet=map.entrySet();

        for (Map.Entry<String, Integer> entry:entrySet) {

            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}
