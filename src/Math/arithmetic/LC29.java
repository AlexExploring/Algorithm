package Math.arithmetic;

/**
 * �������
 *
 * ��������������������dividend�ͳ���divisor�������������Ҫ��ʹ�ó˷��������� mod �������
 * ���ر�����dividend���Գ���divisor�õ����̡�
 * ���������Ľ��Ӧ����ȥ��truncate����С�����֣����磺truncate(8.345) = 8 �Լ� truncate(-2.7335) = -2
 */
public class LC29 {

    public int divide(int a,int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        //^ : ��򣬶Բ���ֵ����ͬΪfalse����ͬΪtrue
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        return sign == 1 ? res : -res;
    }

    public int divide1(int a,int b) {
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        //^ : ��򣬶Բ���ֵ����ͬΪfalse����ͬΪtrue
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) a = -a;
        if (b > 0) b = -b;

        int ans = 0,valueLimit = -1073741824,kLimit = 1073741823;
        while (a <= b) {
            int value = b,k = 1;
            while (value >= valueLimit && a <= value + value) {
                value += value;
                if (k > kLimit) return Integer.MIN_VALUE;
                k += k;
            }
            a -= value;
            ans += k;
        }
        return sign == 1 ? ans : -ans;
    }
}



