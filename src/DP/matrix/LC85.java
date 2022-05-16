package DP.matrix;

/**
 * @author zhxspacex
 * @date 2021/1/2 22:44
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最大矩形
 * 相关题目
 */
public class LC85 {
    public static void main(String[] args) {

    }

    public int maximalRectangle1(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int rows = matrix.length,cols = matrix[0].length;
        int [][] left = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(left[i][j]=='1'){
                    left[i][j] = (j==0 ? 0 : left[i][j-1])+1;
                }
            }
        }

        int ret = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j]==0){
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i-1; k >= 0; k--) {
                    width = Math.min(width,left[k][j]);
                    area = Math.max(area,(i-k+1)*width);
                }
                ret = Math.max(ret,area);
            }
        }
        return ret;
    }

    /**
     *单调栈解法
     */
    public int maximalRectangle2(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[][] left = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int j = 0; j < cols; j++) { // 对于每一列，使用基于柱状图的方法
            int[] up = new int[rows];
            int[] down = new int[rows];

            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < rows; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = rows - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? rows : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < rows; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }
}
