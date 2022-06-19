package array.matrix;

/**
 * 旋转图像
 *
 * 矩阵操作
 */
public class LC48 {
    /**
     * 方法一
     *
     * 内层循环一次确定四个数的位置
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
     * 方法二
     *
     * 一张图先上下反转，再对角反转（右上半角和左下半角交换）
     */
    public void rotate1(int[][] matrix) {
        int len = matrix.length;
        //上下反转
        for (int i = 0; i < len/2; i++) {
            int [] a = matrix[i];
            matrix[i] = matrix[len-i-1];
            matrix[len-i-1] = a;
        }

        //右上半角和左下半角交换
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int a = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = a;
            }
        }
    }
}
