package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC3 {
    public static void main(String[] args) {
        String s1 = "jbpnbwwd";
        System.out.println(lengthOfLongestSubstring(s1));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0,len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                }else {
                    ans = Math.max(set.size(),ans);
                    set.clear();
                    break;
                }
            }
        }
        return Math.max(set.size(),ans);
    }

    /**
     *这种写法，省去了大量不必要的增删操作，从而节省了大量的时间
     */
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}
