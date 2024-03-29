package stack.bracket;

import java.util.Stack;

/**
 * 最长有效括号
 */
public class LC32 {

    /**
     * 一个只包含'('和')'的字符串，找出最长的包含有小括号的子串的长度
     *
     * 暴力枚举加判断是否有效
     *
     * 时间复杂度O(n^3),空间复杂度(1), 超时
     */
    public int longestValidParentheses(String s){
        int max = 0,temp = 0,len = s.length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ')') continue;

            for (int j = i; j < len; j++) {
                String s1 = s.substring(i,j+1);
                if(isValid(s1)){
                    temp = j-i+1;
                }
                if (temp > max){
                    max = temp;temp = 0;
                }
            }
        }

        return max;
    }

    /**
     * 判断是否有效，时间复杂度O(N),空间复杂度O(1)
     */
    public boolean isValid(String s){
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }

    /**
     * 优化 时间复杂度O(N)，空间复杂度O(N)   耗时5ms
     *
     * 具体做法是我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，
     * 这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：
     * 1. 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
     * 2. 对于遇到的每个 ‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号:
     *      2.1 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其
     *      下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括
     *      号的下标」
     *      2.2 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号
     *      为结尾的最长有效括号的长度」
     */
    public int longestValidParentheses1(String s){
        //最开始的-1表示最长子串只能从0开始
        int max = 0,n = s.length();

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }else {
                stack.pop();
                //此时如果stack为空，则需要更新最后一个没有被匹配的右括号的下标，为下面的计算做准备
                if (stack.empty()){
                    stack.push(i);
                }else {
                    max = Math.max(max,i-stack.peek());
                }
            }
        }

        return max;
    }

    /**
     * 优化 时间复杂度O（N），空间复杂度O（1）  耗时2ms
     */
    public int longestValidParentheses2(String s){
        if (s == null || s.length() < 1) return 0;

        int left = 0,right = 0,max =0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else right++;

            if (left == right)
                max = Math.max(max,2*right);
            //当right > left的时候，此时遍历到的有效括号字符串是无效的，left和right均重置为0
            else if(right > left){
                left = right = 0;
            }
        }

        left = right = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else right++;

            if (left == right)
                max = Math.max(max,2*left);
            //由于是从后往前，所以当left > right的时候才是无效的
            else if(left > right){
                left = right = 0;
            }
        }

        return max;
    }
}