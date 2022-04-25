package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 *
 * 和LC567 类似
 */
public class LC438 {

    /**
     * 滑动窗口
     */
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = pLen; i < sLen; ++i) {
            --sCount[s.charAt(i-pLen) - 'a'];
            ++sCount[s.charAt(i) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i-pLen+1);
            }
        }

        //或者
        //for (int i = 0; i < sLen - pLen; ++i) {
        //    --sCount[s.charAt(i) - 'a'];
        //    ++sCount[s.charAt(i+pLen) - 'a'];
        //    if (Arrays.equals(sCount, pCount)) {
        //        ans.add(i+1);
        //    }
        //}

        return ans;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int diff = 0;
        for (int j = 0; j < 26; ++j) {
            //窗口中字母 count[j] 的数量不同
            if (count[j] != 0) {
                ++diff;
            }
        }

        if (diff == 0) {
            ans.add(0);
        }

        for (int i = pLen; i < sLen; i++) {
            int x = s.charAt(i)-'a',y = s.charAt(i-pLen)-'a';

            if (x != y) {
                // 修改之前若有x处的字符相等，则diff+1
                if (count[x] == 0) diff++;
                count[x]++;
                // 修改之后若有x处的字符相等，则diff-1
                if (count[x] == 0) diff--;

                if (count[y] == 0) diff++;
                count[y]--;
                if (count[y] == 0) diff--;
            }

            if (diff == 0) ans.add(i-pLen+1);

        }

        return ans;
    }

    public List<Integer> findAnagrams2(String s, String p) {
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
