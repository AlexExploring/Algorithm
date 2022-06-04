package stack;

import java.util.*;

/**
 * �ַ�������
 */
public class LC394 {

    public static void main(String[] args) {
        System.out.println(new LC394().decodeString("2[a2[bc]]"));
    }

    /**
     * ʹ��ջ������
     */
    private int ptr;

    public String decodeString(String s) {
        ptr = 0;
        LinkedList<String> stack = new LinkedList<String>();

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // ��ȡһ�����ֲ���ջ,���ܻ��������Ķ����λ
                String digit = getDigits(s);
                stack.push(digit);
            } else if (Character.isLetter(cur) || cur == '[') {
                // ��ȡһ����ĸ����ջ����Ϊ�����stack��String���͵ģ����Ա���Ҫ�ַ�ת��Ϊ�ַ���
                stack.push(String.valueOf(cur));
                ptr++;
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stack.peek())) {
                    sub.addLast(stack.pop());
                }

                // �����ų�ջ
                stack.pop();
                // ��ʱջ��Ϊ��ǰ sub ��Ӧ���ַ���Ӧ�ó��ֵĴ���
                int repTime = Integer.parseInt(stack.pop());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);

                // �����ַ���
                while (repTime-- > 0) {
                    t.append(o);
                }

                // ������õ��ַ�����ջ
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
