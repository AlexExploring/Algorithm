package Top100;

import java.util.LinkedList;

/**
 * ÿ���¶�
 */
public class LC739 {
    /**
     * ����ջ
     * ��ջ���ԣ�ֻ��ͬһ�˽�����ɾ����
     */
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int [] ans = new int[len];

        for (int i = 0; i < len; i++) {
            int tem = temperatures[i];
            while (!stack.isEmpty()&&tem>temperatures[stack.peek()]){
               int pre = stack.pop();
               ans[pre] = i-pre;
            }
            stack.push(i);
        }

        return ans;
    }


    /**
     * ����ѭ��
     */

    public int[] dailyTemperatures1(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int current = T[i];
            if (current < 100) {
                for (int j = i + 1; j < length; j++) {
                    if (T[j] > current) {
                        result[i] = j - i;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
