package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 每日温度
 */
public class LC739 {

    /**
     * 单调栈
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int [] ans = new int[len];

        for (int i = 0; i < len; i++) {
            int tem = temperatures[i];
            while (!stack.isEmpty() && tem > temperatures[stack.peek()]) {
                int pre = stack.pop();
                ans[pre] = i-pre;
            }

            stack.push(i);
        }

        return ans;
    }

    /**
     * 暴力循环
     */
    public int[] dailyTemperatures1(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int current = temperatures[i];
            if (current < 100) {
                for (int j = i + 1; j < len; j++) {
                    if (temperatures[j] > current) {
                        ans[i] = j - i;
                        break;
                    }
                }
            }
        }
        return ans;
    }

}
