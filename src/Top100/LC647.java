package Top100;

/**
 * 回文子串
 */
public class LC647 {

    /**
     * 暴力枚举
     */
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i; j < s.length(); j++){
                if (s.charAt(i)==s.charAt(j)&&isPalindrome(s,i,j)) ans++;
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s,int i,int j){
        while (i<=j){
            if (s.charAt(i)==s.charAt(j)){
                i++;j--;
            }else return false;
        }
        return true;
    }

    /**
     * 中心扩展法
     */
    public int countSubstrings1(String s) {
        int n = s.length(),ans = 0,flag = 2*n-1;
        for (int i = 0; i < flag; i++) {
            int l = i/2,r = i/2+i%2;
            while (l>=0&&r<n&&s.charAt(l)==s.charAt(r)){
                l--;r++;ans++;
            }
        }
        return ans;
    }

}
