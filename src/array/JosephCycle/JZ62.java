package array.JosephCycle;

import java.util.ArrayList;

/**
 * ԲȦ�����ʣ�µ�����(Լɪ��ѭ��)
 *
 * ���ݷ�Χ:1 <= n <= 10^5; 1 <= m <= 10^6
 */
public class JZ62 {

    /**
     * ����ģ��ѡ�����
     */
    public int lastRemaining(int n, int m) {
        int [] data = new int[n];
        //flag���ڱ���Ƿ����һ��ѡ��sum���ڼ�¼���ѡ��Ĵ���
        int flag = 0,sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum == n-1) break;
            if (data[i] != -1) flag++;
            if (flag == m) {
                data[i] = -1;flag = 0;sum++;
            }
            if (i == n-1) i = -1;
        }

        //����data[i] != 0��i��Ϊ��
        for (int i = 0; i < n; i++) {
            if (data[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    /**
     * ʹ��ArrayList
     */
    public int lastRemaining1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int idx = 0;
        while (n > 1) {
            //idxΪҪ���Ƴ��������±�
            idx = (idx + m - 1) % n;
            list.remove(idx);   // remove�����ܺ�ʱ��
            n--;
        }

        return list.get(0);
    }

    /**
     *
     */
    public int lastRemaining2(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
