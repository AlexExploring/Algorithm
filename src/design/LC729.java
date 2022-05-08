package design;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * �ճ̱�
 *
 * ���ݽṹ�����򼯺�
 */
public class LC729 {
}

/**
 * ʹ��list�洢��������Ԫ�ص����飬��ʾʱ��Σ�ÿ�ε���book()������ʱ���������list�����
 */
class MyCalendar {

    List<int[]> calendar;

    MyCalendar() {
        calendar = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] iv: calendar) {
            // �����ճ̰��� [s1��e1) �� [s2��e2) ����ͻ��e1<=s2
            // �� e2<=s1������ζ�ŵ� s1<e2 �� s2<e1 ʱ���ճ̰���
            // ������ͻ��
            if (iv[0] < end && start < iv[1]) return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}

/**
 * ��������ʹ�������map �� TreeMap ������ʱ��Σ�
 */
class MyCalendar1 {
    TreeMap<Integer, Integer> calendar;

    MyCalendar1() {
        calendar = new TreeMap();
    }

    /**
     * �����ճ̵�ʱ����Ҫ�ж��������ճ��ǲ����������ڽ��ճ̵ķ�Χ��
     */
    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),  //prev ����С�ڵ���start�ļ�
                next = calendar.ceilingKey(start); // next ��С�Ĵ��ڵ���start�ļ�
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}