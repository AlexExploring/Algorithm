package stack.calculator;

import java.util.Scanner;
import java.util.Stack;

class ZZZ {
    //中缀转后缀
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(trans(s));
    }
    public static String trans(String s){
        int len = s.length();
        Stack<Character> stack = new Stack<>(); //stack用于临时存放操作符
        StringBuilder ans = new StringBuilder(); //存储转换后的后缀表达式
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(c);
            else if (c == ')'){
                while (!stack.isEmpty() && !(stack.peek() == '(')){
                    ans.append(stack.pop());
                    ans.append(" ");
                }

                if (stack.peek() == '(')
                    stack.pop();
            }
            else if (isOperator(c)){
                //栈顶元素的优先级大于等于当前操作符的优先级时
                while (!stack.isEmpty() && priority(stack.peek(),c) >= 0){
                    ans.append(stack.pop());
                    ans.append(" ");
                }
                stack.push(c);
            }
            //字符是操作数
            else {
                StringBuilder t = new StringBuilder();
                while (i < len && !isOperator(s.charAt(i))){
                    t.append(s.charAt(i));
                    i++;
                }
                i--;
                ans.append(new String(t));
                ans.append(" ");
                System.out.println(t);
            }
        }
        //对中缀表达式遍历完毕之后，输出stack中剩余的所有操作符
        while (!stack.isEmpty()){
            ans.append(stack.pop());
            ans.append(" ");
        }
        return new String(ans);
    }

    public static boolean isOperator(char c){
        if (c == '+'||c == '-' || c == '*' || c == '/' || c == '(' ||c == ')')
            return true;
        return false;
    }

    public static int priority(char a,char b)
    {
        if(a=='+'||a=='-')
        {
            if(b=='+'||b=='-')
                return 0;
            if(b=='*'||b=='/')
                return -1;
        }
        if(a=='*'||a=='/')
        {
            if(b=='+'||b=='-')
                return 1;
            if(b=='*'||b=='/')
                return 0;
        }
        return -1;
    }
}