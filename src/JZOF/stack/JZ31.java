package JZOF.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * ջ��ѹ�룬��������
 */
public class JZ31 {

    /**
     * ����һ ���Լ��Ľⷨ
     */
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        if (pushed.length==0||pushed.length==1) return true;
        int index = 1;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < pushed.length; i++) {
            map.put(pushed[i],index++);
        }
        boolean flag = true;
        int pre,cur,max=map.get(popped[0]);
        boolean [] visited = new boolean[pushed.length+1];
        visited[map.get(popped[0])] = true;
        for (int i = 1; i < popped.length; i++) {
            pre = map.get(popped[i-1]);cur = map.get(popped[i]);
            max = Math.max(cur,max);


            if ((pre-cur)>1){
                int t;
                for (t=max; t >= 0; t--) {
                    if (visited[t] == false){
                        break;
                    }
                }
                if (t!=cur){
                    flag = false;break;
                }
            }
            visited[cur] = true;
        }
        return flag;
    }


    /**
     * ʹ��һ������ջ ��pushed�е�����ģ��ѹ��/������
     *
     * ѭ����ջ�� ��stack��ջ��Ԫ��=��������Ԫ��popped[i],��ִ�г�ջ��i++
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
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
