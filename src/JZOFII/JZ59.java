package JZOFII;

import java.util.PriorityQueue;

/**
 * 数据流的第k大数值
 */
public class JZ59 {

}

/**
 * 维护一个大小为k的优先队列
 */
class KthLargest {
    PriorityQueue<Integer> priorityQueue;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<Integer>();
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        priorityQueue.offer(val);
        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }else if (priorityQueue.size() < k) return -1;
        return priorityQueue.peek();
    }
}
