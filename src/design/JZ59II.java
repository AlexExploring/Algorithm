package design;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 *
 * 题目：请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函
 * 数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class JZ59II {
}

/**
 * 暴力，直接实现一个普通的队列，查询最大值的时候遍历所有的值
 */
class MaxQueue {
    int[] q = new int[20000];
    int begin = 0, end = 0;

    public MaxQueue() {

    }

    public int max_value() {
        int ans = -1;
        for (int i = begin; i != end; ++i) {
            ans = Math.max(ans, q[i]);
        }
        return ans;
    }

    public void push_back(int value) {
        q[end++] = value;
    }

    public int pop_front() {
        if (begin == end) {
            return -1;
        }
        return q[begin++];
    }
}

/**
 * 维护一个单调递减的双端队列，
 */
class MaxQueue1 {

    Queue<Integer> q;
    Deque<Integer> d;

    public MaxQueue1() {
        //q中存储所有入队的值
        q = new LinkedList<Integer>();
        //单调递减双端队列
        d = new LinkedList<Integer>();
    }

    /**
     *由于d是单调递减的，要要求最大值，只需要返回d.peekFirst()
     */
    public int max_value() {
        if (d.isEmpty()) {
            return -1;
        }
        return d.peekFirst();
    }

    public void push_back(int value) {
        while (!d.isEmpty() && d.peekLast() < value) {
            d.pollLast();
        }
        d.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        //出队的话，需要将两队列中相同的值都出队
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}
