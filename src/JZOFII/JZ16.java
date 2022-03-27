package JZOFII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 不含重复字符的最长子字符串
 */
public class JZ16 {

    public static void main(String[] args) {
        System.out.println(new JZ16().lengthOfLongestSubstring( "aa"));
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 1 || len == 0) return len;

        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int tail = i+127;
            for (int j = i; j < tail && j < len ; j++) {
                for (int k = i; k <= j; k++) {
                    set.add(s.charAt(k));
                }
                if (set.size()==(j-i+1)){
                    ans = Math.max(ans,j-i+1);
                }
                set.clear();
            }
        }

        return ans;
    }

    /**
     * 滑动窗口
     */
    public int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0,ans = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
