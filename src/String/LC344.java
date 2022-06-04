package String;

/**
 * ��ת�ַ���
 *
 * ��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� s ����ʽ������
 * ��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣
 */
public class LC344 {
    public void reverseString(char[] s) {
        int l = 0,r = s.length-1;
        while (l < r) {
            swap(s,l,r);
            l++;
            r--;
        }
    }

    public void swap(char[] s,int l,int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}
