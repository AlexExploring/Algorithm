package stack;

import java.util.LinkedList;

public class LCtest {

    private int ptr;

    public String decodeString(String s) {
        ptr = 0;
        LinkedList<String> stack = new LinkedList<>();

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                String digit = getDigits(s);
                stack.push(digit);
            }else if (Character.isLetter(cur) || cur == '[') {
                stack.push(String.valueOf(cur));
                ptr++;
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stack.peek())) {
                    sub.addLast(stack.pop());
                }

                stack.pop();
                int repTime = Integer.parseInt(stack.pop());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);

                while (repTime-- > 0) {
                    t.append(o);
                }
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