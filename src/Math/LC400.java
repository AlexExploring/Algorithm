package Math;

/**
 * ����������ĳһλ����
 */
public class LC400 {
    public static void main(String[] args) {

    }

    public int findNthDigit(int n) {
        // n�������ֵ�λ��
        int digit = 1;
        // ���ַ�Χ��ʼ�ĵ�һ����
        long start = 1;
        // ռ����λ
        long count = 9;

        while(n > count){
            n -= count;
            digit++;
            //��һ�����ַ�Χ����ʼ
            start *= 10;
            //��һ����Χ�ڵ���λ��������
            count = digit * start * 9;
        }

        // ָ��λ�������־�������һ������
        long num = start + (n - 1) / digit;

        //ȷ��������λ�� numnum ����һ��λ
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
