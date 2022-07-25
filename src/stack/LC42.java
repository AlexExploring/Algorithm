package stack;

import java.util.Stack;

/**
 * 接雨水
 *
 * 题解链接
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 *
 * 重点是找到计算区间中水的方法
 */
public class LC42 {

    /**
     * 每一次统计出当前列左边列的最大值和右边列的最大值
     */
    public int trap(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                //sum 加上当前列上方可以存储的水
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 动态规划
     */
    public int trap1(int[] height) {
        if (height.length<3) return 0;
        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        //利用动态规划求出每一列的左端最大值
        for (int i = 1; i < height.length - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        //利用动态规划求出每一列的右端最大值
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }

        return sum;
    }

    /**
     * 动态规划解法的优化， 优化了空间复杂度
     */
    public int trap2(int[] height) {
        int sum = 0;
        int max_left = 0;
        int[] max_right = new int[height.length];

        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            max_left = Math.max(max_left, height[i - 1]);
            int min = Math.min(max_left, max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }

        return sum;
    }

    /**
     * 使用栈
     */
    public int trap3(int[] height) {
        int sum = 0;
        int current = 0;
        Stack<Integer> stack = new Stack<>();

        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()]; //取出要出栈的元素
                stack.pop(); //出栈
                if (stack.empty()) { // 栈空就出去
                    break;
                }
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(height[stack.peek()], height[current]);
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }

        return sum;
    }
}
