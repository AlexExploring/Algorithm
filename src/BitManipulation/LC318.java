package BitManipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 题目：给定一个字符串数组words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符
 * 时，它们长度的乘积的最大值。假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对
 * 字符串，返回 0。
 */
public class LC318 {

    /**
     * 暴力法
     */
    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (help(words[i], words[j]))
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }

    /**
     * 判断两个字符串是否具有相同的字符
     */
    public boolean help(String s1, String s2) {
        int[] data = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            data[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (data[s2.charAt(i) - 'a'] != 0) return false;
        }
        return true;
    }

    /**
     * 采用二进制针对 words数组生成一个全是数字的预处理数组，方便进行判断是否含有相同的字符
     */
    public int maxProduct1(String[] words) {
        int[] wordCode = initWordCode(words);
        int result = 0;
        for (int i = 0, end = words.length; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if ((wordCode[i] & wordCode[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

    public int[] initWordCode(String[] words) {
        int[] wordCode = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                wordCode[i] |= (1 << (c - 'a'));
            }
        }
        return wordCode;
    }

    /**
     * 多个字符串的wordCode可能相同，使用map记录一个wordCode 对应的最大的wordLen
     */
    public int maxProduct2(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int wordCode = 0;
            for (char c : words[i].toCharArray()) {
                wordCode |= (1 << (c - 'a'));
            }
            int wordLen = words[i].length();
            if (wordLen > map.getOrDefault(wordCode, 0)) {
                map.put(wordCode, wordLen);
            }
        }

        int result = 0;
        Set<Integer> set = map.keySet();
        for (int wordCode1 : set) {
            int wordLen1 = map.get(wordCode1);
            for (int wordCode2 : set) {
                if ((wordCode1 & wordCode2) == 0) {
                    int wordLen2 = map.get(wordCode2);
                    result = Math.max(result,wordLen1*wordLen2);
                }
            }
        }
        return result;
    }
}
