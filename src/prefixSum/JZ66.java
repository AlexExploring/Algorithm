package prefixSum;

/**
 *  �����˻�����
 */
public class JZ66 {

    /**
     * ������� ���ݷ�Χ <= 10^5;
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
     * ���Խ� result[i] �ֳ������ּ���,��0~i-1,i+1��a.length-1;
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
            //����һ��forѭ���У�result[i]��߲��ֵ�ֵ�Ѿ�������ˣ������ټ�result[i]
            //�ұߵ�ֵtemp���ϣ����õ����յĽ��result[i];
            result[i] *= temp;
        }

        return result;
    }
}
