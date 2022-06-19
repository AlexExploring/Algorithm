package array.matrix;

/**
 * ��תͼ��
 *
 * �������
 */
public class LC48 {
    /**
     * ����һ
     *
     * �ڲ�ѭ��һ��ȷ���ĸ�����λ��
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    /**
     * ������
     *
     * һ��ͼ�����·�ת���ٶԽǷ�ת�����ϰ�Ǻ����°�ǽ�����
     */
    public void rotate1(int[][] matrix) {
        int len = matrix.length;
        //���·�ת
        for (int i = 0; i < len/2; i++) {
            int [] a = matrix[i];
            matrix[i] = matrix[len-i-1];
            matrix[len-i-1] = a;
        }

        //���ϰ�Ǻ����°�ǽ���
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int a = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = a;
            }
        }
    }
}
