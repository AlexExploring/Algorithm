package JZOF.math;

/**
 * ����������ĳһλ����
 */
public class JZ44 {
    public static void main(String[] args) {

    }

    public int findNthDigit(int n) {
        int digit = 1;   // n�������ֵ�λ��
        long start = 1;  // ���ַ�Χ��ʼ�ĵ�һ����
        long count = 9;  // ռ����λ
        while(n > count){
            n -= count;
            digit++;
            start *= 10;
            count = digit * start * 9;
        }
        // ָ��λ�������־�������һ������
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
