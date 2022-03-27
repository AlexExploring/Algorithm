package JZOF.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ���е����ֵ
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
 *ά��һ�������ݼ���˫�˶��У�
 */
class MaxQueue1 {
    Queue<Integer> q;
    Deque<Integer> d;

    public MaxQueue1() {
        //q�д洢������ӵ�ֵ
        q = new LinkedList<Integer>();
        //�����ݼ�˫�˶���
        d = new LinkedList<Integer>();
    }

    /**
     *����d�ǵ����ݼ��ģ�ҪҪ�����ֵ��ֻ��Ҫ����d.peekFirst()
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
        //���ӵĻ�����Ҫ������������ͬ��ֵ������
        int ans = q.poll();
        if (ans == d.peekFirst()) {
            d.pollFirst();
        }
        return ans;
    }
}