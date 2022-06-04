package array.matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class LC54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        LinkedList<Integer> result = new LinkedList<>();
        if(matrix==null||matrix.length==0) return result;

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        //矩阵中的元素个数
        int numEle = matrix.length * matrix[0].length;

        //只有当未打印的元素个数大于等于1才有意义，每一个for循环中都必须加上numEle >= 1
        //因为不知道哪一个for循环结束后，矩阵遍历完成
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                result.add(matrix[top][i]);
                numEle--;
            }
            //遍历完上侧一行
            top++;

            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result.add(matrix[i][right]);
                numEle--;
            }
            //遍历完右侧一列
            right--;

            for (int i = right; i >= left && numEle >= 1; i--) {
                result.add(matrix[bottom][i]);
                numEle--;
            }
            //遍历完下侧一列
            bottom--;

            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result.add(matrix[i][left]);
                numEle--;
            }
            //遍历完左侧一列
            left++;
        }

        return result;
    }
}
