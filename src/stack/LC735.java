package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ������ײ
 */
public class LC735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int ast : asteroids) {
            collision: {
                //ֻ��ast<0������stack.peek()>0ʱ���лᷢ����ײ
                while (!stack.isEmpty() && ast<0 && stack.peek()>0) {
                    //�Ҳ�������������ջ��Ԫ�ػ���
                    if (stack.peek() < -ast){
                        stack.pop();
                        continue;
                        // ��������������� �� һ�����
                    }else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    // ���������������������������������� ���Ҳ�Ļᱻ����ֱ������ collision
                    break collision;
                }
                stack.push(ast);
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}
