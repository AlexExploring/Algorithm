package JZOFII;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * �ճ̱�
 */
public class JZ58 {

}

class MyCalendar {

    List<int[]> calendar;

    MyCalendar() {
        calendar = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] iv: calendar) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}

class MyCalendar1 {
    TreeMap<Integer, Integer> calendar;

    MyCalendar1() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),  //prev ����С�ڵ���start��ֵ
                next = calendar.ceilingKey(start); // next ��С�Ĵ��ڵ���start��ֵ
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}