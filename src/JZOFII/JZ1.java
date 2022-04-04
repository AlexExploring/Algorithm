package JZOFII;

import a_books.Aha.di7izhang.MaximumHeap;

/**
 * ��������
 */
public class JZ1 {

    public static void main(String[] args) {
    }

    /**
     * ��Ϊ�� -2147483648 ת��������Խ�磬���ǽ� 2147483647 ת�ɸ������򲻻�
     * ���ԣ����ǽ� a �� b ��ת�ɸ���
     * ʱ�临�Ӷȣ�O(n)��n �����ֵ 2147483647 --> 10^10 --> ��ʱ
     */
    public int divide(int a, int b) {
        // 32 λ���ֵ��2^31 - 1 = 2147483647
        // 32 λ��Сֵ��-2^31 = -2147483648
        // -2147483648 / (-1) = 2147483648 > 2147483647 Խ����
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        // ����ֻ֧�ִ洢 32 λ����
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        return sign == 1 ? res : -res;
    }

    /**
     * �Ż�
     */
    public int divide1(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;

        int ans = 0,valueLimit = -1073741824,kLimit = 1073741823;
        while (a <= b) {
            int value = b,k = 1;
            //���ڲ��������Ǹ���������ڱ����Ĺ����У����������С��Integer.MIN_VALUE
            //��һ�룬��value��ᷢ�������������Ҫ����;
            while (value >= valueLimit && a <= value+value) {
                value+=value;
                if (k > kLimit) return Integer.MIN_VALUE;
                k+=k;
            }
            a-=value;
            ans+=k;
        }

        return sign == 1 ? ans : -ans;
    }
}
