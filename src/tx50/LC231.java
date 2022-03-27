package tx50;

public class LC231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return true;
        while (n != 1) {
            if (n%2 != 0) return false;
            n/=2;
        }
        return true;
    }

    /**
     * һ���� n�� 2 ���ݣ����ҽ��� n �������������� n �Ķ����Ʊ�ʾ�н����� 1 �� 1��
     */
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

}
