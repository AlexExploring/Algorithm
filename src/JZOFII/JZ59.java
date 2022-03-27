package JZOFII;

import java.util.PriorityQueue;

/**
 * �������ĵ�k����ֵ
 */
public class JZ59 {

}

/**
 * ά��һ����СΪk�����ȶ���
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
