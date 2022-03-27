package JZOFII;

/**
 * ���ʳ��ȵ����˻�
 */
public class JZ5 {
    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (help(words[i],words[j]))
                    max = Math.max(max,words[i].length()*words[j].length());
            }
        }
        return max;
    }

    public boolean help(String s1,String s2) {
        int [] data = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            data[s1.charAt(i)-'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (data[s2.charAt(i)-'a']!=0) return false;
        }
        return true;
    }


    /**
     * ���ö�������� words��������һ��Ԥ�������飬��������ж��Ƿ�����ͬ���ַ�
     */
    public int maxProduct1(String[] words) {
        int[] wordCode = this.initWordCode(words);
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

    private int[] initWordCode(String[] words) {
        int[] wordCode = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                wordCode[i] |= (1<<(c-'a'));
            }
        }
        return wordCode;
    }
}
