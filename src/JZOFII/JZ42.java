package JZOFII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最近请求次数
 */
public class JZ42 {

}

/**
 * 最近的请求次数
 * 满足先进先出，使用队列
 */
class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (t-3000 > queue.peek())
            queue.poll();
        return queue.size();
    }
}
