package Top100;

/**
 * ����λ����
 */
public class LC338 {

    /**
     * ʹ��java����API
     */
    public int[] countBits(int n) {
        int [] ans = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    /**
     * ���������Ĺ���
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
