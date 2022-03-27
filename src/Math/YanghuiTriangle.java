package Math;

public class YanghuiTriangle {
    public static void main(String[] args) {
        test2();
    }

    public static void test() {
        //定义了一个长度为10，高度为10的二维数组，数组中的值都为0；
        int[][] arr=new int[10][10];
        for(int i=0;i<arr.length; i++) {
            //由于只是给杨辉三角内的位置赋值，所以是j<=i
            for(int j=0;j<=i;j++) {
                //根据规律，使用if else 赋值
                if(j==0||j==i) {
                    arr[i][j]=1;
                }else {
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                }
				/*由于只是输出杨辉三角范围内的值，所以在内层循环就输出，这种方法不能全部赋值完之后再输出
					"\t"的原因是10和小于10的数组的宽度不同，所以使用\t制表符能使数与数之间距离相等
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
            // 打印空格字符串
            System.out.format("%" + (rows - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
