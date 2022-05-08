package hash;

import java.util.HashMap;

/**
 * 验证外星语词典
 */
public class LC953 {

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }

        for (int i = 1; i < words.length; i++) {
            //一次判断两个单词的字典序是否符合 order的顺序
            String pre = words[i-1];
            String cur = words[i];
            int n = Math.min(pre.length(),cur.length());

            int flag = 0;
            int j;
            for (j = 0; j < n; j++) {
                // 满足字典序要求，直接break
                if (map.get(pre.charAt(j)) < map.get(cur.charAt(j))) {
                    break;
                }
                // 暂时满足字典序要求，可能需要特殊判断，记flag = 1;
                else if (map.get(pre.charAt(j)) == map.get(cur.charAt(j))) {
                    flag = 1;continue;
                }
                // 不满足字典序要求，直接 return false即可
                else if (map.get(pre.charAt(j)) > map.get(cur.charAt(j))) {
                    return false;
                }
            }

            //按照题目要求，两个字符串长度不相等，前n个字符都相同时，长度较小的字符串的字典序应该更小
            if (j==n&&flag==1&&pre.length()>cur.length()) {
                return false;
            }
        }

        return true;
    }
}
