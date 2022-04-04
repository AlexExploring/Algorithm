package JZOFII;

import java.util.Arrays;

/**
 * ǰ׺��+���ֲ���
 */
public class JZ71 {

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
            //x����mid������ֵ��mid�ز�������Ŀ��ֵ����low = mid + 1
            //x С�ڵ���mid������ֵʱ��mid�п��ܾ���Ŀ��λ�ã���right=mid
            if (x > pre[mid]) {
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return low;
    }
}
