package stack;

import java.util.*;

/**
 *有效括号
 *
 * 重点在于匹配
 */
public class LC20 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(isValid2(scan.nextLine()));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        if (s.charAt(0)==')'||s.charAt(0)=='}'||s.charAt(0)==']') return false;
        else stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else {
                if (!stack.isEmpty()){
                    if (((char)stack.peek()=='('&&s.charAt(i)==')')||
                            ((char)stack.peek()=='{'&&s.charAt(i)=='}')||
                            ((char)stack.peek()=='['&&s.charAt(i)==']')){
                        stack.pop();
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {//可以判断ch是否为右括号,同时判断出了
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    //不需要使用map
    public static boolean isValid2(String s) {
        if(s.isEmpty())
            return true;
        Stack<Character> stack=new Stack<Character>();
        for(char c:s.toCharArray()){
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.empty()||c!=stack.pop())
                return false;
        }
        return stack.empty();
    }
}
