package slidingWindow;

import java.util.HashMap;

/**
 * 最小覆盖子串
 */
public class LC76 {

    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hs = new HashMap<Character,Integer>();
        HashMap<Character,Integer> ht = new HashMap<Character,Integer>();

        //先用ht记录t中各个字符出现的次数
        for(int i = 0;i < t.length();i ++){
            ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i), 0) + 1);
        }

        String ans = "";
        //cnt记录有多少个元素符合;len在的一次由于cnt==t.length()之后，ans.length将只可能小于等len;
        int len = Integer.MAX_VALUE, cnt = 0;

        for(int r = 0,l = 0;r < s.length();r++) {
            hs.put(s.charAt(r), hs.getOrDefault(s.charAt(r), 0) + 1);

            //因为是先将s.charAt(r)放入了hs中，所以是小于等于
            if(ht.containsKey(s.charAt(r)) && hs.get(s.charAt(r)) <= ht.get(s.charAt(r))) cnt++;

            //r<l 并且 (ht中不包含s.charAt(l) 或者 s.charAt(l)在hs中出现的次数大于在ht中出现的次数，)；就可以移动左指针
            while(l < r && (!ht.containsKey(s.charAt(l)) || hs.get(s.charAt(l)) > ht.get(s.charAt(l)))) {
                hs.put(s.charAt(l), hs.get(s.charAt(l)) - 1);
                l++;
            }

            if(cnt == t.length() && r - l + 1 < len){
                len = r - l + 1;
                ans = s.substring(l,r + 1);
            }
        }

        return ans;
    }
}
