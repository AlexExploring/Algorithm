package TwoPointers.palindrome;

/**
 * 验证回文串I
 * 相关题目：LC680
 */
public class LC125 {

    /**
     * 方法一： 先对字符串进行处理
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
     * 边比较，边对字符串进行处理
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
     * 检测字符c是否为数字或字母
     */
    public boolean check(char c) {
        return Character.isLetterOrDigit(c);
    }

    /**
     * 忽略大小写比较两个字符
     */
    public boolean isEquals(char a, char b) {
        if (Character.isLetter(a) && Character.isLetter(b)){
            return Character.toLowerCase(a) == Character.toLowerCase(b);
        }else return a == b;
    }
}
