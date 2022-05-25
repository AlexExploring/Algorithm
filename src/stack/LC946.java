package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * ջ��ѹ�룬��������
 *
 * ע�⣺���ظ�����
 */
public class LC946 {

    /**
     * ʹ��һ������ջ ��pushed�е�����ģ��ѹ��/������
     *
     * ѭ����ջ�� ��stack��ջ��Ԫ��=��������Ԫ��popped[i],��ִ�г�ջ��i++
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num ��ջ
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // ѭ���ж����ջ
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
