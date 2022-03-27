package JZOFII;

import java.util.HashMap;

/**
 * 外星语言是否排序
 */
public class JZ34 {

    public static void main(String[] args) {
        String [] words = {"apap","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(new JZ34().isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }

        for (int i = 1; i < words.length; i++) {
            String pre = words[i-1];
            String cur = words[i];
            int n = Math.min(pre.length(),cur.length());
            int flag = 0;
            int j;
            for (j = 0; j < n; j++) {
                if (map.get(pre.charAt(j))<map.get(cur.charAt(j))) {
                    break;
                }
                else if (map.get(pre.charAt(j))==map.get(cur.charAt(j))) {
                    flag = 1;continue;
                }
                else if (map.get(pre.charAt(j))>map.get(cur.charAt(j))) {
                    return false;
                }
            }
            if (j==n&&flag==1&&pre.length()>cur.length()) { //处理前n个字符均相等的情况
                System.out.println("bot");
                return false;
            }
        }
        return true;
    }
}
