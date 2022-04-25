package TwoPointers;

/**
 * 验证回文串II
 */
public class LC680 {

    public boolean validPalindrome(String s) {
        for (int l = 0, r = s.length()-1; l < r; l++,r--) {
            if (s.charAt(l) != s.charAt(r))
                // 删除l或者r指向的字符
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
