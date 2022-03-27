package JZOFII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �������ڵ�ƽ��ֵ
 */
public class JZ41 {

}

class MovingAverage {
    private int size;
    private Queue<Integer> queue;
    private double total;


    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
        total = 0;
    }

    public double next(int val) {
        if (queue.size() == size) {
            total -= queue.remove();
        }
        queue.add(val);
        total += val;
        return total / queue.size();
    }
}

