package TwoPointers.palindrome;

/**
 * ��֤���Ĵ�II
 *
 * ����һ���ַ��� s����� ���Դ���ɾ��һ���ַ���
 * �����ж� s �Ƿ��ܳ�Ϊ�����ַ���������ܣ�����
 * true �����򣬷��� false ��
 *
 * �����Ŀ: LC125
 */
public class LC680 {

    /**
     * ˼·��LC680
     */
    public boolean validPalindrome(String s) {
        for (int l = 0, r = s.length() - 1; l < r; l++,r--) {
            if (s.charAt(l) != s.charAt(r)) {
                // ɾ��l����rָ����ַ�
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
