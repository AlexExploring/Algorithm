package array.JosephCycle;

import java.util.ArrayList;

/**
 * 圆圈中最后剩下的数字(约瑟夫循环)
 *
 * 数据范围:1 <= n <= 10^5; 1 <= m <= 10^6
 */
public class JZ62 {

    /**
     * 数组模拟选择过程
     */
    public int lastRemaining(int n, int m) {
        int [] data = new int[n];
        //flag用于标记是否完成一次选择，sum用于记录完成选择的次数
        int flag = 0,sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum == n-1) break;
            if (data[i] != -1) flag++;
            if (flag == m) {
                data[i] = -1;flag = 0;sum++;
            }
            if (i == n-1) i = -1;
        }

        //最终data[i] != 0的i即为答案
        for (int i = 0; i < n; i++) {
            if (data[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 使用ArrayList
     */
    public int lastRemaining1(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int idx = 0;
        while (n > 1) {
            //idx为要被移除的数的下标
            idx = (idx + m - 1) % n;
            list.remove(idx);   // remove操作很耗时间
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
