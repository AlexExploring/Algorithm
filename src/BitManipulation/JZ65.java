package BitManipulation;

/**
 * ���üӼ��˳����ӷ�
 *
 * ��LC371��ͬ
 */
public class JZ65 {
    public static void main(String[] args) {
        System.out.println(new JZ65().add(9, 11));
    }

    /**
     *  λ����+����ʵ��
     */
    public int add(int a, int b) {
        while(b != 0) {
            // c = ÿλ�Ľ�λ
            int c = (a & b) << 1;
            // a = �ǽ�λ��
            a ^= b;
            // b = ��λ
            b = c;
        }
        return a;
    }

    /**
     * �ݹ�ʵ��
     */
    public int add1(int a, int b) {
        if (a == 0 || b == 0)
            return a ^ b;
        return add1(a ^ b, (a & b) << 1);
    }

}