package stack;

import java.util.Scanner;
/**
 * @author zhxspacex
 * @date 2020/12/15 14:35
 */
public class size {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String houzhui = ZZZH.trans(s);
        System.out.println("后缀表达式为："+houzhui);
        double ans = CalHouZhui.calHouZhui(houzhui);
        System.out.println(ans);
    }
}
