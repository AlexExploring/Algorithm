package BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 *�������
 *
 * ��������������������dividend�ͳ���divisor�������������Ҫ��ʹ�ó˷��������� mod �������
 * ���ر�����dividend���Գ���divisor�õ����̡�
 * ���������Ľ��Ӧ����ȥ��truncate����С�����֣����磺truncate(8.345) = 8 �Լ� truncate(-2.7335) = -2
 */
public class LC29 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE/2);
    }

    /**
     * ֱ��ʹ��long�洢 dividend �� divisor�ľ���ֵ����ֹ���
     */
    public int divide(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        long t = Math.abs((long) a);
        long d= Math.abs((long) b);
        int result = 0;
        for (int i=31; i>=0;i--) {
            if ((t>>i)>=d) {//�ҳ��㹻�����2^n*divisor
                result+=1<<i;//���������2^n
                t-=d<<i;//����������ȥ2^n*divisor
            }
        }
        return sign == 1 ? result : -result;//��������ȡ��
    }

    /**
     * ��ĿҪ�󻷾�ֻ�ܴ洢32λ����
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



