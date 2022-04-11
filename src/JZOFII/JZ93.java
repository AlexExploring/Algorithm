package JZOFII;

import java.util.HashSet;
import java.util.Set;

/**
 * �쳲��������� ����LC873��ͬ��
 */
public class JZ93 {

    /**
     * ʹ��set�ı�����
     */
    public int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Set<Integer> set = new HashSet<>();
        for (int el : arr) {
            set.add(el);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int x = arr[j],y = arr[i]+arr[j];
                int length = 2;
                while (set.contains(y)) {
                    int temp = y;
                    y+=x;
                    x = temp;
                    ans = Math.max(ans,++length);
                }
            }
        }

        return ans >= 3 ? ans : 0;
    }

    /**
     * ��̬�滮��û����
     */
}
