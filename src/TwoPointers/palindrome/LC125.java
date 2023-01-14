package TwoPointers.palindrome;

/**
 * ��֤���Ĵ�I
 * �����Ŀ��LC680
 */
public class LC125 {

    /**
     * ����һ�� �ȶ��ַ������д���
     */
    public boolean isPalindrome(String s) {
        s.trim();
        if (s.equals("")) return true;

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                if (Character.isLetter(c)) {
                    c = Character.toLowerCase(s.charAt(i));
                }
                temp.append(c);
            }
        }

        int l = 0,r = temp.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }

        return true;
    }

    /**
     * �߱Ƚϣ��߶��ַ������д���
     */
    public boolean isPalindrome1(String s) {
        int l = 0,r = s.length()-1;
        while (l < r) {
            while (l < r && !check(s.charAt(l))) l++;
            while (l < r && !check(s.charAt(r))) r--;
            if (l < r && !isEquals(s.charAt(l),s.charAt(r))) return false;
            l++;r--;
        }

        return true;
    }

    /**
     * ����ַ�c�Ƿ�Ϊ���ֻ���ĸ
     */
    public boolean check(char c) {
        return Character.isLetterOrDigit(c);
    }

    /**
     * ���Դ�Сд�Ƚ������ַ�
     */
    public boolean isEquals(char a, char b) {
        if (Character.isLetter(a) && Character.isLetter(b)){
            return Character.toLowerCase(a) == Character.toLowerCase(b);
        }else return a == b;
    }
}
