package JZOF.array;

/**
 *顺时针打印矩阵
 *
 */
public class JZ29 {
    public static void main(String[] args) {


    }

    /**
     * 模拟
     */
    public int[] spiralOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;

            // 如果不换方向 下一个点的行列值
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];

            // 判断不换方向的话，下一个点的行列值是否合法，如果不合法，则重新判断方向
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    /**
     * 按层模拟
     */
    public int[] spiralOrder2(int[][] matrix) {
        int row = matrix.length;
        if (row==0) return new int[0];
        int col = matrix[0].length;
        int [] res = new int[col*row];
        int idx = 0;
        int left = 0,top = 0,right = col - 1,bottom = row - 1;

        //通过四个参数控制方向
        while (true) {

            for (int i = left; i <= right; i++) {
                res[idx++] = matrix[top][i];
            }
            //向右走完一行，上边界top下移一行
            if (++top > bottom) {  //top 会加1
                break;
            }
            //从上往下走
            for (int i = top; i <= bottom; i++) {
                res[idx++] = matrix[i][right];
            }
            //向下走完一行，右边界right左移一行
            if (--right < left) {
                break;
            }
            //从右往左走
            for (int i = right; i >= left; i--) {
                res[idx++] = matrix[bottom][i];
            }
            //向左走完一行，下边界bottom上移一行
            if (--bottom < top) {
                break;
            }
            //从下往上走
            for (int i = bottom; i >= top; i--) {
                res[idx++] = matrix[i][left];
            }
            //向上走完一行，左边界向右移一行
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
