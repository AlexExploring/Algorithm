package hash;

import java.util.HashMap;

/**
 *第一个只出现一次的字符
 */
public class JZ50 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("abbaccdeff"));
    }

    /**
     *暴力  32ms
     */
    public static char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) map.put(s.charAt(i),0);
            else map.put(s.charAt(i),1);
        }

        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }

        return ans==-1 ? ' ' : s.charAt(ans);
    }


    /**
     *使用数组实现  4ms
     */
    public static char firstUniqChar1(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (char ch : chars){
            arr[ch -'a'] ++;
        }
        for (char c:chars){
            if (arr[c-'a'] == 1){
                return c;
            }
        }
        return ' ';
    }

    /**
     * 2ms
     */
    public static char firstUniqChar2(String s) {
        if(s.isEmpty()) return ' ';
        int min = s.length();
        char ch =' ';
        for(char i='a';i<='z';i++){
            int pos = s.indexOf(i);
            if(pos != -1 && pos == s.lastIndexOf(i)){
                if(pos < min){
                    ch = i;
                    min = pos;
                }
                //System.out.println(i);
            }
        }
        return ch;
    }
}
