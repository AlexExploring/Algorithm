package Top100;

/**
 * ��תͼ��
 *
 * �������
 */
public class LC48 {
    public static void main(String[] args) {
        int [][] matrix = new int[4][];

        matrix[0] = new int[]{5,1,9,11};
        matrix[1] = new int[]{2,4,8,10};
        matrix[2] = new int[]{13,3,6,7};
        matrix[3] = new int[]{15,14,12,16};

        rotate1(matrix);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * ����һ
     */
    public static void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int t1 = 0,t2 = len-(t1+1); t1 < len/2; t1++,t2--) {
            for (int i1=t1,i2=len-(t1+1),j1=t1,j2=len-(t1+1);
                 i1<len-(t1+1)&&i2>t1&&j1<len-(t1+1)&&j2>t1; i1++,i2--,j1++,j2--) {
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
        for (int i = 0; i < len/2; i++) {
            int [] a = matrix[i];
            matrix[i] = matrix[len-i-1];
            matrix[len-i-1] = a;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int a = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = a;
            }
        }
    }
}
