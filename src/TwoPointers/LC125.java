package TwoPointers;

/**
 * ��֤���Ĵ�
 */
public class LC125 {

    /**
     * ����һ�� �ȶ��ַ������д���
     */
    public boolean isPalindrome(String s) {
        s = s.trim();
        if (s.equals("")) return false;

        StringBuffer newS = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))||Character.isLetter(s.charAt(i))) {
                if (Character.isLetter(s.charAt(i))){
                    newS.append(Character.toLowerCase(s.charAt(i)));
                }else newS.append(s.charAt(i));
            }
        }

        int left = 0,right = newS.length()-1;
        while (left<=right) {
            if (newS.charAt(left)==newS.charAt(right)){
                left++;right--;
            }else return false;
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
        return Character.isDigit(c) || Character.isLetter(c);
    }

    /**
     * ����ַ�c�Ƿ�Ϊ���ֻ���ĸ
     */
    public boolean check1(char c) {
        return 'a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9';
    }

    /**
     * ���Դ�Сд�Ƚ������ַ�
     */
    public boolean isEquals(char a, char b) {
        if (Character.isLetter(a)&&Character.isLetter(b)){
            return Character.toLowerCase(a)==Character.toLowerCase(b);
        }else return a==b;
    }

    /**
     * ���Դ�Сд�Ƚ������ַ�
     */
    public boolean isEquals1(char a, char b) {
        if ('A' <= a && a <= 'Z') a = (char)(a + 32);
        if ('A' <= b && b <= 'Z') b = (char)(b + 32);
        return a == b;
    }
}
