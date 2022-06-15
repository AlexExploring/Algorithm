package Top100;

/**
 * ��תͼ��
 *
 * �������
 */
public class LC48 {

    /**
     * ����һ
     */
    public static void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int t1 = 0,t2 = len-(t1+1); t1 < len/2; t1++,t2--) {
            for (int i1 = t1,i2 = len-(t1+1),j1 = t1,j2 = len-(t1+1);
                 i1 < len-(t1+1) && i2 > t1 && j1 < len-(t1+1) && j2 > t1;
                    i1++,i2--,j1++,j2--) {
                int a = matrix[t1][j1],b=matrix[i1][t2],
                        c=matrix[t2][j2],d=matrix[i2][t1];
                matrix[t1][j1]=d;matrix[i1][t2]=a;matrix[t2][j2]=b;matrix[i2][t1]=c;
            }
        }
    }

    /**
     * ������
     *
     * һ��ͼ�����·�ת���ٶԽǷ�ת�����ϰ�Ǻ����°�ǽ�����
     */
    public static void rotate1(int[][] matrix) {
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
