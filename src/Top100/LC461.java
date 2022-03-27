package Top100;

public class LC461 {
    public int hammingDistance1(int x, int y) {
        return Integer.bitCount(x^y);
    }

    public int hammingDistance2(int x, int y) {
        int s = x^y,ret = 0;
        while (s!=0){
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }


}
