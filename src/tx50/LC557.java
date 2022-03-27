package tx50;

public class LC557 {

    /**
     * 使用split函数去除空格
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

    /**
     *
     */
    public String reverseWords1(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            //去除空格
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
