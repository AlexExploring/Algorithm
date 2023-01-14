package TwoPointers.palindrome;

/**
 * 验证回文串II
 *
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * 请你判断 s 是否能成为回文字符串：如果能，返回
 * true ；否则，返回 false 。
 *
 * 相关题目: LC125
 */
public class LC680 {

    /**
     * 思路见LC680
     */
    public boolean validPalindrome(String s) {
        for (int l = 0, r = s.length() - 1; l < r; l++,r--) {
            if (s.charAt(l) != s.charAt(r)) {
                // 删除l或者r指向的字符
                return isPalindrome(s,l+1,r) || isPalindrome(s,l,r-1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s,int l,int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
