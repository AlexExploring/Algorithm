package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 最大矩形
 * 相关题目
 */
public class LC85 {

    /**
     * 思路：left[i][j] 为矩阵第 i 行第 j 列元素的左边连续 1(包括第i行第j列)的数量。
     * 随后，对于矩阵中任意一个点，我们枚举以该点为右下角的全 1 矩形。
     * 具体而言，当考察以 matrix[i][j] 为右下角的矩形时，我们枚举满足
     * 0≤k≤i 的所有可能的 k，此时矩阵的最大宽度就为
     * left[i][j],left[i−1][j],…,left[k][j] 的最小值。
     */
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length,cols = matrix[0].length;
        if (rows == 0) return 0;

        int[][] left = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != '0') {
                    int width = left[i][j];
                    int area = width;
                    for (int k = i - 1; k >= 0; k--) {
                        width = Math.min(width, left[k][j]);
                        area = Math.max(area, (i - k + 1) * width);
                    }
                    ans = Math.max(ans, area);
                }
            }
        }

        return ans;
    }

    /**
     * 单调栈解法
     */
    public int maximalRectangle1(char[][] matrix) {
        int rows = matrix.length,cols = matrix[0].length;
        if (rows == 0) return 0;

        int[][] left = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int ans = 0;

        // 对于每一列，使用基于柱状图的方法, 处理每一列都像处理一个柱状图（LC84）
        for (int j = 0; j < cols; j++) {
            //上边界
            int[] up = new int[rows];
            //下边界
            int[] down = new int[rows];
            Arrays.fill(down,rows);

            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < rows; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    down[stack.peek()] = i;
                    System.out.println("j="+j+"  down["+stack.peek()+"]="+i);
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < rows; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                ans = Math.max(ans, area);
            }
        }

        return ans;
    }
}