package stack.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @author zhxspacex
 * @date 2020/12/17 10:54
 */
public class Calculator implements ActionListener{
    private JFrame frame;
    private JTextField tf;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    private JButton [] jButtons = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16};
    private String tex = "789+456-123*0.=/";
    private StringBuilder stringb = new StringBuilder();
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.go();
    }

    public void go(){
        frame = new JFrame("Calculator");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);

        int startx = 0,starty = 0;
        for (int k = 0; k < 16; k++) {
            jButtons[k] = new JButton(String.valueOf(tex.charAt(k)));
            jButtons[k].setBounds(startx,starty,60,40);
            jButtons[k].addActionListener(this);
            contentPane.add(jButtons[k]);
            if ((k+1)%4==0){
                startx=0;starty+=42;
            }else {
                startx+=62;
            }
        }

        tf = new JTextField(260);
        contentPane.add(tf);
        tf.setBounds(0,170,260,40);

        //注册事件监听
        frame.setSize(280,300);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("=")){
            double ans = CalHouZhui.calHouZhui(ZZZH.trans(String.valueOf(stringb)));
            tf.setText(String.valueOf(ans));
            stringb.delete(0,stringb.length());
        }else {
            stringb.append(s);
            tf.setText(String.valueOf(stringb));
        }
    }
}

class ZZZH {
    //中缀转后缀
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

    public static boolean isOperator(char c) {
        if (c == '+'||c == '-' || c == '*' || c == '/' || c == '(' ||c == ')')
            return true;
        return false;
    }

    public static int priority(char a,char b) {
        if(a == '+' || a == '-')
        {
            if(b == '+' || b == '-')
                return 0;
            if(b == '*' || b == '/')
                return -1;
        }
        if(a == '*' || a == '/')
        {
            if(b == '+' || b == '-')
                return 1;
            if(b == '*' || b == '/')
                return 0;
        }
        return -1;
    }
}

class CalHouZhui {
    public static double calHouZhui(String s){
        double temp = 0,ans = 0;
        String [] t = s.split(" ");
        ArrayList<String> anslist = new ArrayList();
        for (int i = 0; i < t.length; i++) {
            anslist.add(t[i]);
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println(t[i]);
        }
        Stack<Double> stack = new Stack();
        for (String a : anslist){
            if (Character.isDigit(a.charAt(0))){{
                stack.push(Double.valueOf(a));
                System.out.println("放入"+Double.valueOf(a));
            }
            }else {
                double t1 = stack.pop();
                double t2 = stack.pop();
                char c = a.charAt(0);
                System.out.println("t1："+t1+"和"+"t2："+t2+" "+c);
                temp = tReslut(t2,t1,c); //为什么是t2,t1而不是t1,t2？为了保证计算的顺序和输入的顺序一样
                stack.push(temp);
                System.out.println("   "+"结果为"+temp);
                System.out.println("   "+"栈顶元素为"+stack.peek());
            }
        }
        return stack.peek();
    }

    public static double tReslut(double t1, double t2, char c){
        double t;
        if (c=='+') t = t1+t2;
        else if (c=='-') t = t1-t2;
        else if (c=='*') t = t1*t2;
        else t = t1/t2;
        return t;
    }
}