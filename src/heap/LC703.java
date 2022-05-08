package heap;

import java.util.PriorityQueue;

/**
 * �������ĵ�k����ֵ
 */
public class LC703 {

}

/**
 * ά��һ����СΪk�����ȶ���
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
            // ��Ŀ���ݱ�֤���ڲ��ҵ� k ��Ԫ��ʱ�������������� k ��Ԫ�أ�
            // ����δ�����Բ�Ҫ���������֤�Ļ��������Ҫ�ӡ�
        }else if (priorityQueue.size() < k) {
            return -1;
        }
        return priorityQueue.peek();
    }
}
