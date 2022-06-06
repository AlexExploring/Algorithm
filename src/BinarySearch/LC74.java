package BinarySearch;

/**
 *搜索二维数组I
 *
 * 相关题目
 * LC240 搜索二维数组II
 *
 * 两道题目的数据范围不一样
 */
public class LC74 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            }
            if (matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     *结合改二维数组的特点，从右上角开始遍历,和遍历一颗二叉搜索树一样
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0,column = matrix[0].length - 1;

        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            }
            if (matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }
}
