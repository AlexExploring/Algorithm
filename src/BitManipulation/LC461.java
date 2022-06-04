package BitManipulation;

/**
 * 汉明距离
 */
public class LC461 {

    /**
     * Integer.bitCount() 统计二进制表示中1的个数
     */
    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x^y);
    }

    /**
     * 两个数的^,二进制表示中，相同为0，不同为1
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
