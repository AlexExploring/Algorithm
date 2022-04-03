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

    /**
     * ֱ��ʹ��long�洢 dividend �� divisor�ľ���ֵ����ֹ���
     */
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) return Integer.MIN_VALUE;
            if (divisor == -1) return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }

        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
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
    public int divide1(int dividend, int divisor) {
        // ���Ǳ�����Ϊ��Сֵ�����
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // ���ǳ���Ϊ��Сֵ�����
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // ���Ǳ�����Ϊ 0 �����
        if (dividend == 0) {
            return 0;
        }

        //��������ȡ��
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        boolean rev = false;
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;

        List<Integer> candidates = new ArrayList<Integer>();
        candidates.add(divisor);
        int index = 0;
        // ע�����
        while (candidates.get(index) >= dividend - candidates.get(index)) {
            candidates.add(candidates.get(index) + candidates.get(index));
            ++index;
        }
        int ans = 0;
        for (int i = candidates.size() - 1; i >= 0; --i) {
            if (candidates.get(i) >= dividend) {
                ans += 1 << i;
                dividend -= candidates.get(i);
            }
        }

        return rev ? -ans : ans;
    }
}



