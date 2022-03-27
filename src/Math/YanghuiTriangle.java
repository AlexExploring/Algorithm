package Math;

public class YanghuiTriangle {
    public static void main(String[] args) {
        test2();
    }

    public static void test() {
        //������һ������Ϊ10���߶�Ϊ10�Ķ�ά���飬�����е�ֵ��Ϊ0��
        int[][] arr=new int[10][10];
        for(int i=0;i<arr.length; i++) {
            //����ֻ�Ǹ���������ڵ�λ�ø�ֵ��������j<=i
            for(int j=0;j<=i;j++) {
                //���ݹ��ɣ�ʹ��if else ��ֵ
                if(j==0||j==i) {
                    arr[i][j]=1;
                }else {
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                }
				/*����ֻ�����������Ƿ�Χ�ڵ�ֵ���������ڲ�ѭ������������ַ�������ȫ����ֵ��֮�������
					"\t"��ԭ����10��С��10������Ŀ�Ȳ�ͬ������ʹ��\t�Ʊ����ʹ������֮��������
				*/
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void test1() {
        int[][] arr=new int[10][];
        for(int i=0;i<arr.length;i++) {
            arr[i]=new int[i+1];
        }
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                if(j==0 || i==j) {
                    arr[i][j]=1;
                }else {
                    arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
                }
            }
        }
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void test2() {
        int rows = 10;

        for (int i = 0; i < rows; i++) {
            int number = 1;
            // ��ӡ�ո��ַ���
            System.out.format("%" + (rows - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
