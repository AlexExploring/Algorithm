package design;

import java.util.*;

/**
 * 滑动窗口的平均值
 */
public class LC346 {

}

/**
 * 基于队列进行设计
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
