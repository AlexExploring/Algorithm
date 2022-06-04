package BitManipulation;

/**
 * 2����
 *
 * �����Ŀ��LC326��3���ݣ�
 */
public class LC231 {

    /**
     * ���n��2���ݣ���ôn�Ķ����Ʊ�ʾ�У�ֻ�����λ��1������λ����0
     */
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
     * ���n��2���ݣ���ôn-1�������λ��Ϊ1������λ��Ϊ1�� n&(n-1һ��Ϊ0
     */
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }
}
