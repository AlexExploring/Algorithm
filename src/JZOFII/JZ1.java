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
        // 32 λ���ֵ��2^31 - 1 = 2147483647
        // 32 λ��Сֵ��-2^31 = -2147483648
        // -2147483648 / (-1) = 2147483648 > 2147483647 Խ����
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        // ����ֻ֧�ִ洢 32 λ����
        a = Math.abs(a);
        b = Math.abs(b);

        int res = 0;
        while (a <= b) {
            //value һ�������ձ�������ֵ
            int value = b;
            int k = 1;
            // 0xc0000000 ��ʮ���� -2^30 ��ʮ�����Ƶı�ʾ
            // �ж� value >= 0xc0000000 ��ԭ�򣺱�֤ value + value �������
            // ���������жϵ�ԭ���ǣ�0xc0000000 ����Сֵ -2^31 ��һ�룬
            // �� a ��ֵ�����ܱ� -2^31 ��ҪС������ value �����ܱ� 0xc0000000 С
            // -2^31 / 2 = -2^30
            while (value >= 0xc0000000 && a <= value + value) {
                value += value;
                // �����Ż������ k �Ѿ��������ֵ��һ��Ļ�����ôֱ�ӷ�����Сֵ
                // ��Ϊ���ʱ�� k += k �Ļ��϶�����ڵ��� 2147483648 �������������Ŀ���ķ�Χ
                if (k > Integer.MAX_VALUE / 2) {
                    return Integer.MIN_VALUE;
                }
                k += k;
            }
            a -= value;
            res += k;
        }

        return sign == 1 ? res : -res;
    }
}
