package heap;

import java.util.PriorityQueue;

/**
 * 数据流的第k大数值
 */
public class LC703 {

}

/**
 * 维护一个大小为k的优先队列
 */
class KthLargest {

    private PriorityQueue<Integer> priorityQueue;
    private int k;

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
            // 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素，
            // 则这段代码可以不要，如果不保证的话，则必须要加。
        }else if (priorityQueue.size() < k) {
            return -1;
        }
        return priorityQueue.peek();
    }
}
