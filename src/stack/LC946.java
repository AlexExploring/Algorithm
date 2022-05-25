package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 栈的压入，弹出序列
 *
 * 注意：无重复数字
 */
public class LC946 {

    /**
     * 使用一个辅助栈 对pushed中的数据模拟压入/弹出，
     *
     * 循环出栈， 若stack的栈顶元素=弹出序列元素popped[i],则执行出栈与i++
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
