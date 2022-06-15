package Top100;

import backTrack.arrangement.LC47I;

/**
 * ��תͼ��
 *
 * �������
 */
public class LC48 {

    public static void main(String[] args) {
        int [][] mat = new int[3][];
        mat[0] = new int[]{1,2,3};
        mat[1] = new int[]{4,5,6};
        mat[2] = new int[]{7,8,9};
        new LC48().rotate(mat);
    }

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
