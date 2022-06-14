package String.PalindromeString;

/**
 * 最长回文子串
 */
public class LC5 {

    /**
     * 暴力枚举所有长度严格大于1的子串,并对每一子串判断是否为回文字符串
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int start = 0,maxLen = 1;
        char [] a = s.toCharArray();

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if (isPalindrome(a,i,j) && j-i+1 > maxLen){
                    start = i;
                    maxLen = j-i+1;
                }
            }
        }

        return s.substring(start,start+maxLen);
    }

    public boolean isPalindrome(char [] a,int l,int r){
        while (l < r){
            if (a[l] != a[r]){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    /**
     * 中心扩展法,枚举所有可能的回文中心
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            //一个位置作为回文中心
            int len1 = expandAroundCenter(s, i, i);
            //两个位置作为回文中心
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                //下面的处理，可以保证len==len1 或者 len=len2的情况都能算出正确的值
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
        }
        return r - l - 1;
    }

    /**
     * 动态规划:
     * 状态：dp[i][j]表示子串s[i][j]是否为回文子串
     * 得到状态转移方程：dp[i][j]=(s[i] == s[j]) and dp[i+1][j-1];
     * 边界条件：j-1-(i+1)+1 < 2 （表达式[i+1,j-1]不构成区间，即长度严格小于2） 字符串的长度小于2时不用检查字符串是否回文,即j-i<3,
     *  即j-i+1 < 4,当s[i...j]长度为2或者3时，不用检查子串是否回文
     * 由小规模问题到大规模问题，尽可能利用之前的解，得到新问题的解
     */
    public String longestPalindrome2(String s){
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1,begin = 0;
        boolean [][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char [] a = s.toCharArray();

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (a[i] != a[j]) {
                    dp[i][j] = false;
                } else {
                    if (j-i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                //只要dp[i][j]==true成立，就表示子串s[i...j]是回文，此时记录回文长度和起始位置
                //j-i+1表示当前字符串长度，
                if (dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin+maxLen);
    }
}
