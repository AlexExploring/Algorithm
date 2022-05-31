package prefixSum;

/**
 *  构建乘积数组
 */
public class JZ66 {

    /**
     * 暴力求解 数据范围 <= 10^5;
     */
    public int[] constructArr(int[] a) {
        int len = a.length;
        int [] res = new int[len];

        for (int i = 0; i < len; i++) {
            int t = 1;
            for (int j = 0; j < len; j++) {
                if (i == j) continue;
                t *= a[j];
            }
            res[i] = t;
        }
        return res;
    }

    /**
     * 可以将 result[i] 分成两部分计算,即0~i-1,i+1到a.length-1;
     */
    public int[] constructArr1(int[] a) {
        int len = a.length;
        if(len == 0) return a;

        int[] result = new int[len];
        result[0] = 1;

        for(int i = 1; i <len; i++){
            result[i] = result[i - 1] * a[i - 1];
        }

        int temp = 1;
        for(int i = len - 2; i >= 0; i--){
            temp *= a[i + 1];
            //在上一个for循环中，result[i]左边部分的值已经计算好了，现在再见result[i]
            //右边的值temp乘上，即得到最终的结果result[i];
            result[i] *= temp;
        }

        return result;
    }
}
