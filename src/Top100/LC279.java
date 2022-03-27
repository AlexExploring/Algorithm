package Top100;

/**
 * ��ȫƽ����
 */
public class LC279 {

    /**
     * ����һ������ n �����غ�Ϊ n ����ȫƽ������ �������� ��
     *
     * ��̬�滮
     */
    public int numSquares(int n) {
        int [] f = new int[n];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                minn = Math.min(minn,f[i-j*j]);
            }
            f[i] = minn+1;
        }
        return f[n];
    }
}
