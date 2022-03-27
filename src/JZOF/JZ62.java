package JZOF;

import java.util.ArrayList;

public class JZ62 {
    public static void main(String[] args) {
        System.out.println(lastRemaining1(10,17));
    }

    /**
     * ����ʱ������
     */
    public static int lastRemaining(int n, int m) {
        int [] data = new int[n];
        int flag = 0,sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum==n-1) break;
            if (data[i]!=-1) flag++;
            if (flag==m) {
                data[i]=-1;flag=0;sum++;
            }
            if (i==n-1) i=-1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (data[i]==0) {
                ans = i;break;
            }
        }
        return ans;
    }

    //ʹ�ö�̬���飬ÿ����m��������̬�����ɾ��������ʱ�临�Ӷ�ΪO(N);
    //
    public static int lastRemaining1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);   // remove�����ܺ�ʱ��
            n--;
        }
        return list.get(0);
    }

    //��ѧ��ʽ
    public static int lastRemaining2(int n, int m) {
        return 0;
    }
}
