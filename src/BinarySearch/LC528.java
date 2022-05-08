package BinarySearch;

import java.util.Arrays;

/**
 * 按权重随机生成随机数
 */
public class LC528 {

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
    public LC528(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            pre[i] = pre[i-1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        int x = (int)(Math.random()*total) + 1;
        return binarySearch(x);
    }

    /**
     * 在pre中查找第一个大于等于x的数的下标i
     */
    public int binarySearch(int x) {
        int l = 0,r = pre.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (pre[mid] < x){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l;
    }

    /**
     * 在pre中查找第一个大于等于x的数的下标i
     */
    private int binarySearch1(int x) {
        int l = 0, r = pre.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (pre[mid] < x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
