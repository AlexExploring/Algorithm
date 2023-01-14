package TwoPointers.palindrome;

/**
 * �����Ӵ�
 *
 * ����һ���ַ��� s ������ͳ�Ʋ���������ַ����� �����Ӵ� ����Ŀ��
 *      �����ַ��� �����Ŷ��͵�������һ�����ַ�����
 *      ���ַ��� ���ַ����е��������ַ���ɵ�һ�����С�
 * ���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ
 * ������ͬ���Ӵ���
 */
public class LC647 {

    /**
     * ����ö��
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
     * ������չ��
     *
     * ����һ������Ϊn���ַ�����˵���������ĵ��У�2*n-1������
     * ���Ǿ���Ҫ�������е�������չ����������չ�Ա�õ���ͬ��
     * �����Ӵ�
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
     * ������չ��
     */
    public int countSubstrings2(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            //j=0,������һ���㣬j=1,������������
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
