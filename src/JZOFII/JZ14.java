package JZOFII;

import java.util.Arrays;

/**
 * 字符创中的变位词
 */
public class JZ14 {

    public static void main(String[] args) {
        System.out.println(new JZ14().checkInclusion2("abc", "cbaebabacd"));
    }
    
    /**
     * 滑动窗口  
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(),len2 = s2.length();
        if (len1>len2) return false;
        int [] count1 = new int[26];
        int [] count2 = new int[26];

        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i)-'a']++;
            count2[s2.charAt(i)-'a']++;
        }
        if (Arrays.equals(count1,count2)) return true;

        for (int i = len1; i < len2; i++) {
            count2[s2.charAt(i-len1)-'a']--;
            count2[s2.charAt(i)-'a']++;
            if (Arrays.equals(count1,count2)) return true;
        }

        return false;
    }

    /**
     * 直接比较两个数组是否相同太消耗时间，这里进行优化  
     */
    public boolean checkInclusion1(String s1, String s2) {
        int len1 = s1.length(),len2 = s2.length();
        if (len1>len2) return false;

        int [] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i)-'a']--;
            count[s2.charAt(i)-'a']++;
        }

        int diff = 0;
        for (int i : count) {
            if (i!=0) diff++;
        }
        if (diff == 0) return true;

        for (int i = len1; i < len2; i++) {
            int x = s2.charAt(i)-'a',y = s2.charAt(i-len1)-'a';

            if (x == y) continue;

            if (count[x] == 0) diff++;
            count[x]++;
            if (count[x] == 0) diff--;

            if (count[y] == 0) diff++;
            count[y]--;
            if (count[y] == 0) diff--;

            if (diff == 0) return true;
        }

        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        int len1 = s1.length(),len2 = s2.length();
        if (len1>len2) return false;

        int [] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i)-'a']--;
        }

        int left = 0;
        for (int right = 0; right < len2; right++) {
            int x = s2.charAt(right)-'a';
            count[x]++;
            while (count[x]>0) {
                count[s2.charAt(left)-'a']--;
                left++;
            }
            if (right-left+1==len1) return true;
        }

        return false;
    }
}
