package String;

/**
 * ��ת�ַ����еĵ���III
 */
public class LC557 {

    /**
     * ʹ��split����ȥ���ո�
     */
    public String reverseWords(String s) {

        String[] splits = s.split("\\s+");
        StringBuilder ans = new StringBuilder();

        for (String split : splits) {

            int len = split.length();
            char[] chars = split.toCharArray();

            for (int i = 0; i < len / 2; i++) {
                char temp = chars[i];
                chars[i] = chars[len - i - 1];
                chars[len - i - 1] = temp;
            }

            ans.append(chars);
            ans.append(" ");
        }

        return ans.toString().trim();
    }
}
