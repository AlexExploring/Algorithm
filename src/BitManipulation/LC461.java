package BitManipulation;

/**
 * ��������
 */
public class LC461 {

    /**
     * Integer.bitCount() ͳ�ƶ����Ʊ�ʾ��1�ĸ���
     */
    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x^y);
    }

    /**
     * ��������^,�����Ʊ�ʾ�У���ͬΪ0����ͬΪ1
     */
    public int hammingDistance2(int x, int y) {
        int s = x^y,ret = 0;
        while (s!=0){
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }
}
