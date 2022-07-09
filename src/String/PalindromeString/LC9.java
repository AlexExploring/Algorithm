package String.PalindromeString;

/**
 * ������
 */
public class LC9 {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        String s = Integer.toString(x);
        int len = s.length();

        int l, r;
        if (len % 2 == 0) {
            l = len / 2 - 1;
            r = len / 2;
        } else {
            l = r = len / 2;
        }

        while (l >= 0 && r < len) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l--;
            r++;
        }

        return true;
    }

    public boolean isPalindrome1(int x) {
        // ���������
        // ������������ x < 0 ʱ��x ���ǻ�������
        // ͬ���أ�������ֵ����һλ�� 0��Ϊ��ʹ������Ϊ���ģ�
        // �����һλ����ҲӦ���� 0
        // ֻ�� 0 ������һ����
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // �����ֳ���Ϊ����ʱ�����ǿ���ͨ�� revertedNumber/10 ȥ��������λ�����֡�
        // ���磬������Ϊ 12321 ʱ���� while ѭ����ĩβ���ǿ��Եõ� x = 12��revertedNumber = 123��
        // ���ڴ�����λ�����ֲ�Ӱ����ģ����������Լ���ȣ����������ǿ��Լ򵥵ؽ���ȥ����
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
