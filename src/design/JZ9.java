package design;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ������ջʵ�ֶ���
 */
public class JZ9 {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(4);
        queue.appendTail(3);
        queue.appendTail(-1);
        queue.appendTail(7);

        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}

class CQueue {

    Deque<Integer> A,B;

    public CQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.push(value);
    }

    public int deleteHead() {
        if(!B.isEmpty()) return B.pop();

        if(A.isEmpty()) return -1;
        //��A�е���������B��
        //��A[7,-1,3,4]
        //��B[4,3,-1,7]
        while(!A.isEmpty())
            B.push(A.pop());

        return B.pop();
    }
}
