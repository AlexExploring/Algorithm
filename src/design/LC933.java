package design;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最近的请求次数
 */
public class LC933 {

}

/**
 * 基于队列进行设计
 */
class RecentCounter {

    private Deque<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        int flag = t - 3000;
        while (queue.getFirst() < flag) {
            queue.poll();
        }
        return queue.size();
    }
}
