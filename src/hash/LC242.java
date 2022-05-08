package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 有效的字母异位词 （只包含小写字母）
 */
public class LC242 {

    public boolean isAnagram(String s, String t) {
        int sLen = s.length(),tLen = t.length();
        if (sLen != tLen) return false;

        int [] count = new int[26];
        for (int i = 0; i < sLen; i++) {
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for (int num : count) {
            if (num != 0) return false;
        }

        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;

        int [] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)-'a']--;
            if (count[t.charAt(i)-'a']<0) return false;
        }

        return true;
    }

    /**
     * 进阶: 如果输入字符串包含 unicode 字符怎么办？
     *
     * 思路：直接使用map来记录频次
     */

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> table = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
