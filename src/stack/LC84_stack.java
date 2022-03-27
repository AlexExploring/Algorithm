package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhxspacex
 * @date 2021/1/5 22:25
 */

/**
 *柱状图中的最大矩形
 */
public class LC84_stack {
    public static void main(String[] args) {
        int [] a = {6,7,5};
        System.out.println(largestRectangleArea3(a));
    }

    /**
     *超出时间限制
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights==null||heights.length == 0){
            return 0;
        }

        int ret = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = heights[i];
            int area = width;
            for (int k = i-1; k >= 0; k--) {
                width = Math.min(width,heights[k]);
                area = Math.max(area,(i-k+1)*width);
            }
            ret = Math.max(ret,area);
        }
        return ret;
    }
    /**
     *超出时间限制
     */
    public static int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        int ans = 0;
        // 枚举左边界
        for (int left = 0; left < n; ++left) {
            int minHeight = Integer.MAX_VALUE;
            // 枚举右边界
            for (int right = left; right < n; ++right) {
                // 确定高度
                minHeight = Math.min(minHeight, heights[right]);
                // 计算面积
                ans = Math.max(ans, (right - left + 1) * minHeight);
            }
        }
        return ans;
    }
    /**
     *超出时间限制
     */
    public static int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int ans = 0;
        for (int mid = 0; mid < n; ++mid) {
            // 枚举高
            int width = heights[mid];
            int left = mid, right = mid;
            // 确定左右边界
            while (left - 1 >= 0 && heights[left - 1] >= width) {
                --left;
            }
            while (right + 1 < n && heights[right + 1] >= width) {
                ++right;
            }
            // 计算面积
            ans = Math.max(ans, (right - left + 1) * width);
        }
        return ans;
    }

    /**
     *单调栈
     */
    public static int largestRectangleArea3(int[] heights) {
        int len = heights.length;
        //left中存储的是左边界（不包括左边界）
        int [] left = new int[len];
        //right中存储的是右边界（不包括右边界）
        int [] right = new int[len];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        stack.clear();
        for (int i = len - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? len : stack.peek());
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans,(right[i]-left[i]-1)*heights[i]);
        }
        return ans;
    }

    /**
     *单调栈加常数优化
     */
    public static int largestRectangleArea4(int[] heights) {
        int len = heights.length;
        //left中存储的是左边界（不包括左边界）
        int [] left = new int[len];
        //right中存储的是右边界（不包括右边界）
        int [] right = new int[len];
        Arrays.fill(right,len);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans,(right[i]-left[i]-1)*heights[i]);
        }
        return ans;
    }
}
