package BitManipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ��Ŀ������һ���ַ�������words������㵱�����ַ��� words[i] �� words[j] ��������ͬ�ַ�
 * ʱ�����ǳ��ȵĳ˻������ֵ�������ַ�����ֻ����Ӣ���Сд��ĸ�����û�в�������ͬ�ַ���һ��
 * �ַ��������� 0��
 */
public class LC318 {

    /**
     * ������
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
     * �ж������ַ����Ƿ������ͬ���ַ�
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
     * ���ö�������� words��������һ��ȫ�����ֵ�Ԥ�������飬��������ж��Ƿ�����ͬ���ַ�
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
     * ����ַ�����wordCode������ͬ��ʹ��map��¼һ��wordCode ��Ӧ������wordLen
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
