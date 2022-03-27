package JZOF;

import java.util.Arrays;

/**
 *构建乘积数组
 */
public class JZ66 {
    public static void main(String[] args) {
        int [] data = {1,2,3,4,5};
        int [] res = constructArr1(data);
        System.out.println(Arrays.toString(res));
    }

    /**
     *暴力求解 数据范围 <= 10^5;
     */
    public static int[] constructArr(int[] a) {
        int [] res = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            int t = 1;
            for (int j = 0; j < a.length; j++) {
                if (i==j) continue;
                t*=a[j];
            }
            res[i] = t;
        }
        return res;
    }

    /**
     *可以将 result[i] 分成两部分计算,即0~i-1,i+1到a.length-1;
     */
    public static int[] constructArr1(int[] a) {
        if(a.length == 0) return a;
        int[] result = new int[a.length];
        result[0] = 1;
        for(int i = 1; i < a.length; i++){
            result[i] = result[i - 1] * a[i - 1];
        }

        int temp = 1;
        for(int i = a.length - 2; i >= 0; i--){
            temp *= a[i + 1];
            result[i] *= temp;
        }
        return result;
    }
}
