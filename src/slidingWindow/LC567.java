package slidingWindow;

import java.util.Arrays;

/**
 * 字符串中的排列
 *
 * 和LC438类似
 */
public class LC567 {

    /**
     * 思路：由于变位词不会改变字符串中每个字符的个数，所以只有当两个字符串每个
     * 字符的个数均相等时，一个字符串才是另一个字符串的变位词。
     *
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
            //i != 0 说明 （char）i+'a' ; 有不同
            if (i!=0) diff++;
        }
        if (diff == 0) return true;

        for (int i = len1; i < len2; i++) {
            int x = s2.charAt(i)-'a',y = s2.charAt(i-len1)-'a';
            //当前的字符和 窗口内的第一个字符相等，不会对diff产生影响，直接跳过
            if (x == y) continue;

            // 修改之前若有x处的字符相等，则diff+1
            if (count[x] == 0) diff++;
            count[x]++;
            // 修改之后若有x处的字符相等，则diff-1
            if (count[x] == 0) diff--;

            if (count[y] == 0) diff++;
            count[y]--;
            if (count[y] == 0) diff--;

            if (diff == 0) return true;
        }

        return false;
    }

    /**
     * 双指针
     */
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
