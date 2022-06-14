package stack.bracket;

import java.util.*;

/**
 * 有效的括号
 */
public class LC20 {

    public static boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            //判断c是否为右括号,也可以拆成多个if语句，不过这样写更优雅
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    /**
     * 如果是左括号，则向栈中放置对应的右括号，方便比较
     */
    public static boolean isValid1(String s) {
        if (s.isEmpty()) return true;

        Deque<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }

        return stack.isEmpty();
    }
}