package array.matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * ��������
 */
public class LC54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        LinkedList<Integer> result = new LinkedList<>();
        if(matrix==null||matrix.length==0) return result;

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        //�����е�Ԫ�ظ���
        int numEle = matrix.length * matrix[0].length;

        //ֻ�е�δ��ӡ��Ԫ�ظ������ڵ���1�������壬ÿһ��forѭ���ж��������numEle >= 1
        //��Ϊ��֪����һ��forѭ�������󣬾���������
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                result.add(matrix[top][i]);
                numEle--;
            }
            //�������ϲ�һ��
            top++;

            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result.add(matrix[i][right]);
                numEle--;
            }
            //�������Ҳ�һ��
            right--;

            for (int i = right; i >= left && numEle >= 1; i--) {
                result.add(matrix[bottom][i]);
                numEle--;
            }
            //�������²�һ��
            bottom--;

            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result.add(matrix[i][left]);
                numEle--;
            }
            //���������һ��
            left++;
        }

        return result;
    }
}
