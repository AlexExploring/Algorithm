package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 行星碰撞
 */
public class LC735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        for (int ast : asteroids) {
            collision: {
                //只有ast<0，并且stack.peek()>0时才有会发生碰撞
                while (!stack.isEmpty() && ast<0 && stack.peek()>0) {
                    //右侧行星质量更大，栈顶元素毁灭
                    if (stack.peek() < -ast){
                        stack.pop();
                        continue;
                        // 两侧行星质量相等 则 一起毁灭
                    }else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    // 左侧的行星质量更大或者两侧行星质量相等 ，右侧的会被毁灭，直接跳出 collision
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
