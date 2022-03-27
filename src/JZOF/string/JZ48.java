package JZOF.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class JZ48 {
    public int lengthOfLongestSubstring(String s) {
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

    public int lengthOfLongestSubstring1(String s) {
        // ��¼�ַ���һ�γ��ֵ�λ��
        int[] last = new int[128];
        int n = s.length();

        int res = 0;
        int start = 0; // ���ڿ�ʼλ��
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index]+1); //Ϊʲô��1����Ϊ���ܰ����ظ����ַ�
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }



    /**
     * iΪ��ʼ��߽�  7ms
     */
    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // ������ָ�� i
            dic.put(s.charAt(j), j); // ��ϣ���¼
            res = Math.max(res, j - i); // ���½��
        }
        return res;
    }

    /**
     * ���Ի�ȡi
     */
    public int lengthOfLongestSubstring4(String s) {
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while(i >= 0 && s.charAt(i) != s.charAt(j)) i--; // ���Բ��� i
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    /**
     * dic�������Ǽ�¼�ַ����һ�γ��ֵ�λ��
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // ��ȡ���� i
            dic.put(s.charAt(j), j); // ���¹�ϣ��
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

}
