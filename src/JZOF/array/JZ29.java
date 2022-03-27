package JZOF.array;

/**
 *˳ʱ���ӡ����
 *
 */
public class JZ29 {
    public static void main(String[] args) {


    }

    /**
     * ģ��
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

            // ����������� ��һ���������ֵ
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];

            // �жϲ�������Ļ�����һ���������ֵ�Ƿ�Ϸ���������Ϸ����������жϷ���
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    /**
     * ����ģ��
     */
    public int[] spiralOrder2(int[][] matrix) {
        int row = matrix.length;
        if (row==0) return new int[0];
        int col = matrix[0].length;
        int [] res = new int[col*row];
        int idx = 0;
        int left = 0,top = 0,right = col - 1,bottom = row - 1;

        //ͨ���ĸ��������Ʒ���
        while (true) {

            for (int i = left; i <= right; i++) {
                res[idx++] = matrix[top][i];
            }
            //��������һ�У��ϱ߽�top����һ��
            if (++top > bottom) {  //top ���1
                break;
            }
            //����������
            for (int i = top; i <= bottom; i++) {
                res[idx++] = matrix[i][right];
            }
            //��������һ�У��ұ߽�right����һ��
            if (--right < left) {
                break;
            }
            //����������
            for (int i = right; i >= left; i--) {
                res[idx++] = matrix[bottom][i];
            }
            //��������һ�У��±߽�bottom����һ��
            if (--bottom < top) {
                break;
            }
            //����������
            for (int i = bottom; i >= top; i--) {
                res[idx++] = matrix[i][left];
            }
            //��������һ�У���߽�������һ��
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
