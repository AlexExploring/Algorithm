package Top100;

/**
 * 比特位计数
 */
public class LC338 {

    /**
     * 使用java内置API
     */
    public int[] countBits(int n) {
        int [] ans = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    /**
     * 二进制数的规律
     *
     *
     */
    public int[] countBits1(int n) {
        int [] ans = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            if (i%2==1){
                ans[i] = ans[i-1]+1;
            }else {
                ans[i] = ans[i/2];
            }
        }
        return ans;
    }
}
