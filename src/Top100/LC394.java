package Top100;

import java.rmi.StubNotFoundException;
import java.util.*;

/**
 * 字符串解码
 */
public class LC394 {

    /**
     * 暴力
     */
    public String decodeString(String s) {
        String ans = new String(s);

        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < ans.length(); i++) {
            if (Character.isDigit(ans.charAt(i))) {
                int start = 0;
                for (int j = i+1; j < ans.length(); j++) {
                    if (!Character.isDigit(ans.charAt(j))) {
                        start = j;
                        break;
                    }
                }

                int left = 0,right = 0,end = 0;
                for (int j = start; j < ans.length(); j++) {
                    if (ans.charAt(j)=='[') left++;
                    else if (ans.charAt(j)==']') right++;

                    if (left!=0&&left==right) {
                        end = j;
                        break;
                    }
                }

                String pre;
                if (i==0) pre = "";
                else pre = ans.substring(0,i);

                int times = Integer.valueOf(ans.substring(i,start));
                String data = ans.substring(start+1,end);
                String middle = "";
                for (int j = 1; j <= times; j++) {
                    middle+=data;
                }

                String post;
                if (end+1>=ans.length()) post = "";
                else post = ans.substring(end+1);

                pre+=middle;
                pre+=post;
                ans = pre;

                i--;
            }
        }
        return ans;
    }

    /**
     * 使用栈来处理
     */
    int ptr;
    public String decodeString1(String s) {
        LinkedList<String> stack = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digit = getDigits(s);
                stack.push(digit);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stack.push(String.valueOf(s.charAt(ptr++)));
            } else {
                System.out.println(ptr);
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

    public String getDigits1(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = ptr; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(ptr))){
                res.append(s.charAt(ptr++));
            }else break;
        }
        return res.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

}
