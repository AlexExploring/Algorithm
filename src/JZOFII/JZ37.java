package JZOFII;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 小行星碰撞
 */
public class JZ37 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int ast : asteroids) {
            collision: {
                while (!stack.isEmpty() && ast<0 && stack.peek()>0) {
                    if (stack.peek() < -ast){
                        stack.pop();
                        continue;
                    }else if (stack.peek() == -ast) {
                        stack.pop();
                    }
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
