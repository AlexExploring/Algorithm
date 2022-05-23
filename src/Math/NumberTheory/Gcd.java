package Math.NumberTheory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//扩展欧几里得
// 任意两个数，互质；不能凑出来的最大数：a×b-a-b
public class Gcd{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(lcm(55,495));

    }

    /**
     *求最大公约数
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    /**
     *求最大公倍数
     */
    public static int lcm(int a,int b){
        int t = gcd(a,b);
        return (a*b)/t;
    }


    static int x = 0,y = 0;
    public static void extendGcd(int a, int b){
        if (b==0){
           x = 1;y = 0;
           return;
        }
        extendGcd(a,a%b);
        int temp = x;
        x = y;
        y = temp - (a/b)*y;
    }
}
