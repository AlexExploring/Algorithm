package slidingWindow;

import java.util.HashMap;

/**
 * ��С�����Ӵ�
 */
public class LC76 {

    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hs = new HashMap<Character,Integer>();
        HashMap<Character,Integer> ht = new HashMap<Character,Integer>();

        //����ht��¼t�и����ַ����ֵĴ���
        for(int i = 0;i < t.length();i ++){
            ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i), 0) + 1);
        }

        String ans = "";
        //cnt��¼�ж��ٸ�Ԫ�ط���;len�ڵ�һ������cnt==t.length()֮��ans.length��ֻ����С�ڵ�len;
        int len = Integer.MAX_VALUE, cnt = 0;

        for(int r = 0,l = 0;r < s.length();r++) {
            hs.put(s.charAt(r), hs.getOrDefault(s.charAt(r), 0) + 1);

            //��Ϊ���Ƚ�s.charAt(r)������hs�У�������С�ڵ���
            if(ht.containsKey(s.charAt(r)) && hs.get(s.charAt(r)) <= ht.get(s.charAt(r))) cnt++;

            //r<l ���� (ht�в�����s.charAt(l) ���� s.charAt(l)��hs�г��ֵĴ���������ht�г��ֵĴ�����)���Ϳ����ƶ���ָ��
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
