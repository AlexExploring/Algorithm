package String.PalindromeString;

/**
 * ������Ӵ�
 */
public class LC5 {

    /**
     * ����ö�����г����ϸ����1���Ӵ�,����ÿһ�Ӵ��ж��Ƿ�Ϊ�����ַ���
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
     * ������չ��,ö�����п��ܵĻ�������
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            //һ��λ����Ϊ��������
            int len1 = expandAroundCenter(s, i, i);
            //����λ����Ϊ��������
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                //����Ĵ������Ա�֤len==len1 ���� len=len2��������������ȷ��ֵ
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
     * ��̬�滮:
     * ״̬��dp[i][j]��ʾ�Ӵ�s[i][j]�Ƿ�Ϊ�����Ӵ�
     * �õ�״̬ת�Ʒ��̣�dp[i][j]=(s[i] == s[j]) and dp[i+1][j-1];
     * �߽�������j-1-(i+1)+1 < 2 �����ʽ[i+1,j-1]���������䣬�������ϸ�С��2�� �ַ����ĳ���С��2ʱ���ü���ַ����Ƿ����,��j-i<3,
     *  ��j-i+1 < 4,��s[i...j]����Ϊ2����3ʱ�����ü���Ӵ��Ƿ����
     * ��С��ģ���⵽���ģ���⣬����������֮ǰ�Ľ⣬�õ�������Ľ�
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

                //ֻҪdp[i][j]==true�������ͱ�ʾ�Ӵ�s[i...j]�ǻ��ģ���ʱ��¼���ĳ��Ⱥ���ʼλ��
                //j-i+1��ʾ��ǰ�ַ������ȣ�
                if (dp[i][j] && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin,begin+maxLen);
    }
}
