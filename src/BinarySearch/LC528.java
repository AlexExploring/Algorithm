package BinarySearch;

import java.util.Arrays;

/**
 * ��Ȩ��������������
 */
public class LC528 {

    private int[] pre;
    private int total;

    /**
     * pre[i] = pre[i-1]+w[i];
     * ��ˣ���������� pre[i] ��ʾ���� w ��ǰ׺�ͣ�
     * ��ô�� i ���������߽���� pre[i] - w[i] + 1���ұ߽���� pre[i]��
     * ��������ɺ󣬼������������������ x������ϣ���ҵ����㣺
     * pre[i]-w[i]+1 �� x �� pre[i]
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
     * ��pre�в��ҵ�һ�����ڵ���x�������±�i
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
     * ��pre�в��ҵ�һ�����ڵ���x�������±�i
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
