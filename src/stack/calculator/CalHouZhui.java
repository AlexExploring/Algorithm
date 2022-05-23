package stack.calculator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class HouZhui {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(calHouZhui(s));
    }
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