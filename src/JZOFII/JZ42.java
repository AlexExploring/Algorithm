package JZOFII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����������
 */
public class JZ42 {

}

/**
 * ������������
 * �����Ƚ��ȳ���ʹ�ö���
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
