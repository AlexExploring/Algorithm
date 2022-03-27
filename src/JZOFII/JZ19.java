package JZOFII;

/**
 * 最多删除一个字符得到回文
 */
public class JZ19 {

    public boolean validPalindrome(String s) {
        for (int l = 0, r = s.length()-1; l < r; l++,r--) {
            if (s.charAt(l) != s.charAt(r))
                return isPalindrome(s,l+1,r) || isPalindrome(s,l,r-1);
        }
        return true;
    }

    public boolean isPalindrome(String s,int l,int r) {
        while (l<r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
