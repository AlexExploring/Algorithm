package String;

/**
 * ×óÐý×ª×Ö·û´®
 */
public class JZ58II {

    public static String reverseLeftWords(String s, int n) {
        if (n >= s.length()) return s;

        StringBuffer res = new StringBuffer();
        for (int i = n; i < s.length(); i++) res.append(s.charAt(i));
        for (int i = 0; i < n; i++) res.append(s.charAt(i));

        return res.toString();
    }

    public String reverseLeftWords1(String s, int n) {
        return s.substring(n,s.length())+s.substring(0,n);
    }
}
