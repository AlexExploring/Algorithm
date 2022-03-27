package JZOFII;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ֱ��ͼ���������
 */
public class JZ39 {

    /**
     * ���� ��ʱ
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int left = i;
            int curHeight = heights[i];
            while (left>0 && heights[left-1] >= curHeight) {
                left--;
            }

            int right = i;
            while (right<len-1 && heights[right+1] >= curHeight) {
                right++;
            }

            int width = right-left+1;
            res = Math.max(res,width*curHeight);
        }
        return res;
    }

    /**
     * ջ
     */
    public int largestRectangleArea1(int[] heights) {
        int len = heights.length;
        if (len == 1) {
            return heights[0];
        }

        int res = 0;
        Deque<Integer> stack = new LinkedList();
        for (int i = 0; i < len; i++) {
            // ��� while �ܹؼ�����Ϊ�п��ܲ�ֹһ�����ε�����ȿ��Ա��������
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int curHeight = heights[stack.pop()];
                while (!stack.isEmpty() && heights[stack.peek()] == curHeight) {
                    stack.pop();
                }

                int curWidth;
                if (stack.isEmpty()) {
                    curWidth = i;
                } else {
                    curWidth = i - stack.peek() - 1;
                }

                // System.out.println("curIndex = " + curIndex + " " + curHeight * curWidth);
                res = Math.max(res, curHeight * curWidth);
            }
            stack.push(i);
        }

        // ����ջ�� ���ֵ�ǴӴ�С����
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pop()];
            while (!stack.isEmpty() && heights[stack.peek()] == curHeight) {
                stack.pop();
            }
            int curWidth;
            if (stack.isEmpty()) {
                curWidth = len;
            } else {
                curWidth = len - stack.peek() - 1;
            }
            res = Math.max(res, curHeight * curWidth);
        }
        return res;
    }
}
