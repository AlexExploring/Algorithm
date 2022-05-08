package design;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 日程表
 *
 * 数据结构：有序集合
 */
public class LC729 {
}

/**
 * 使用list存储含有两个元素的数组，表示时间段，每次调用book()方法的时候遍历整个list来检查
 */
class MyCalendar {

    List<int[]> calendar;

    MyCalendar() {
        calendar = new ArrayList();
    }

    public boolean book(int start, int end) {
        for (int[] iv: calendar) {
            // 两个日程安排 [s1，e1) 和 [s2，e2) 不冲突：e1<=s2
            // 或 e2<=s1。这意味着当 s1<e2 和 s2<e1 时，日程安排
            // 发生冲突。
            if (iv[0] < end && start < iv[1]) return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}

/**
 * 方法二：使用有序的map 即 TreeMap 来保存时间段，
 */
class MyCalendar1 {
    TreeMap<Integer, Integer> calendar;

    MyCalendar1() {
        calendar = new TreeMap();
    }

    /**
     * 新增日程的时候，需要判断新增的日程是不是在两个邻近日程的范围内
     */
    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),  //prev 最大的小于等于start的键
                next = calendar.ceilingKey(start); // next 最小的大于等于start的键
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
}