package BitManipulation;

/**
 * ��Ŀ���ͣ�λ����
 *
 * ��Ŀ�������������� a �� b ����ʹ�� ����� + �� - �����㲢����������֮�͡�
 */
public class LC371 {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a&b) << 1;
            a = a^b;
            b = carry;
        }
        return a;
    }
}
