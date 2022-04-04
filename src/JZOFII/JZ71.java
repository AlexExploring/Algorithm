package JZOFII;

import java.util.Arrays;

/**
 * 前缀和+二分查找
 */
public class JZ71 {

    private int[] pre;
    private int total;

    /**
     * pre[i] = pre[i-1]+w[i];
     * 因此，如果我们用 pre[i] 表示数组 w 的前缀和：
     * 那么第 i 个区间的左边界就是 pre[i] - w[i] + 1，右边界就是 pre[i]。
     * 当划分完成后，假设我们随机到了整数 x，我们希望找到满足：
     * pre[i]-w[i]+1 ≤ x ≤ pre[i]
     *
     */
    public JZ71(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 0; i < w.length; i++) {
            pre[i] = pre[i-1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        int x = (int)(Math.random()*total) + 1;
        return binarySearch(x);
    }

    public int binarySearch(int x) {
        int low = 0,high = pre.length-1;
        while (low < high) {
            int mid = (high-low)/2+low;
            //x大于mid处的数值，mid必不可能是目标值，故low = mid + 1
            //x 小于等于mid处的数值时，mid有可能就是目标位置，故right=mid
            if (x > pre[mid]) {
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return low;
    }
}
