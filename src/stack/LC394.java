package stack;

import java.util.*;

/**
 * 字符串解码
 */
public class LC394 {

    public static void main(String[] args) {
        System.out.println(new LC394().decodeString("2[a2[bc]]"));
    }

    /**
     * 使用栈来处理
     */
    private int ptr;

    public String decodeString(String s) {
        ptr = 0;
        LinkedList<String> stack = new LinkedList<String>();

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈,可能会有连续的多个数位
                String digit = getDigits(s);
                stack.push(digit);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈，因为定义的stack是String类型的，所以必须要字符转化为字符串
                stack.push(String.valueOf(cur));
                ptr++;
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stack.peek())) {
                    sub.addLast(stack.pop());
                }

                // 左括号出栈
                stack.pop();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stack.pop());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);

                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }

                // 将构造好的字符串入栈
                stack.push(t.toString());
            }
        }

        return new StringBuffer(getString(stack)).reverse().toString();
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
