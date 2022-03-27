package JZOF.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 */
public class JZ59II {
    public static void main(String[] args) {

    }
}

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
 *维护一个单调递减的双端队列，
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

    //
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