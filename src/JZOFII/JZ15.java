package JZOFII;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串中所有的变位词
 */
public class JZ15 {

    public static void main(String[] args) {
        for (Integer anagram : new JZ15().findAnagrams("cbaebabacd","abc")) {
            System.out.println(anagram);
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        int len1 = p.length(), len2 = s.length();
        List<Integer> ans = new ArrayList<>();
        if (len1 > len2) return ans;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[p.charAt(i) - 'a']--;
        }

        int left = 0;
        for (int right = 0; right < len2; right++) {
            int x = s.charAt(right) - 'a';
            count[x]++;
            while (count[x] > 0) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == len1) ans.add(left);
        }

        return ans;
    }
}
