package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * LC49 字母异位词分组 （只包含小写字母）
 * 和LC567 类似
 */
public class LC438 {

    /**
     * 滑动窗口，只需要保证窗口内各个字符的数量相同，则证明是一个字母异位词
     * 窗口不断右移，
     *
     * ans中存储的是每个字母异位词的起始下标
     */
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        //初始化窗口
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = pLen; i < sLen; ++i) {
            //移除窗口最左边的元素
            --sCount[s.charAt(i-pLen) - 'a'];
            //向窗口中添加当前元素
            ++sCount[s.charAt(i) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i-pLen+1);
            }
        }

        return ans;
    }

    /**
     * 滑动窗口优化：上面方法中，每次对两个字符数组进行比较，很耗时间
     */
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

        //用一个diff来记录窗口中字符数量不同的个数
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
                //向窗口右侧添加元素
                // 修改之前若有x处的字符相等，则diff+1
                if (count[x] == 0) diff++;
                count[x]++;
                // 修改之后若有x处的字符相等，则diff-1
                if (count[x] == 0) diff--;

                //移除窗口最左边的元素
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
