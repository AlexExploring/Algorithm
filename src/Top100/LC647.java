package Top100;

/**
 * �����Ӵ�
 */
public class LC647 {

    /**
     * ����ö��
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
     * ������չ��
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
