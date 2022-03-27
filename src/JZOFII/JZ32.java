package JZOFII;

import java.util.Arrays;

/**
 * 有效的变位词
 */
public class JZ32 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) return false;

        int [] a = new int[26];
        int [] b = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            b[t.charAt(i)-'a']++;
        }

        return Arrays.equals(a,b);
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length() || s.equals(t)) return false;

        int [] data = new int[26];
        for (int i = 0; i < s.length(); i++) {
            data[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            data[t.charAt(i)-'a']--;
            if (data[t.charAt(i)-'a']<0) return false;
        }

        return true;
    }
}
