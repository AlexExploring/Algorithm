package TwoPointers.palindrome;

/**
 * 回文子串
 *
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *      回文字符串 是正着读和倒过来读一样的字符串。
 *      子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被
 * 视作不同的子串。
 */
public class LC647 {

    /**
     * 暴力枚举
     */
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && isPalindrome(s, i, j)) ans++;
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中心扩展法
     *
     * 对于一个长度为n的字符串来说，它的中心点有（2*n-1）个，
     * 我们就需要从这所有的中心扩展点向两边扩展以便得到不同的
     * 回文子串
     */
    public int countSubstrings1(String s) {
        int n = s.length(), ans = 0, flag = 2 * n - 1;
        for (int i = 0; i < flag; i++) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l--) == s.charAt(r++)) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 中心扩展法
     */
    public int countSubstrings2(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            //j=0,中心是一个点，j=1,中心是两个点
            for (int j = 0; j < 2; j++) {
                int l = i;
                int r = i + j;
                while (l >= 0 && r < n && s.charAt(l--) == s.charAt(r++)) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
