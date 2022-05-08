package design;

import java.util.*;

/**
 * �������ڵ�ƽ��ֵ
 */
public class LC346 {

}

/**
 * ���ڶ��н������
 */
class MovingAverage {

    private int size;
    private double sum;
    Deque<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        queue = new LinkedList<Integer>();
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        queue.offer(val);
        sum +=  val;
        return sum/ queue.size();
    }
}
