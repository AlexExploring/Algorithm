package JZOF.recursion;

/**
 *斐波那契数列
 */
public class JZ10_1 {
    public static void main(String[] args) {
        System.out.println(fib3(100));
    }

    static int mod = ((int) Math.pow(10,9))+7;
    public static int fib1(int n) {
        return fib_back1(n)%mod;
    }

    //递归写法，必超时  并且当n>45之后就会超出int类型能表达的最大值
    public static int fib_back1(int n){
        if (n<=1) return n;
        else return fib_back1(n-1)+fib_back1(n-2);
    }

    public static int fib2(int n) {
        return fib_back2(n);
    }

    //递推+递推过程中取模
    public static int fib_back2(int n){
        if (n<=1) return n;
        int a = 1,b = 1,c = 1;
        while (n--!=2){
            c = (a+b)%mod;
            a = b;b = c;
        }
        return c;
    }

    public static int fib3(int n) {
        return fib_back3(n,0,1);
    }
    //尾递归+中间过程取模防止超出表示范围，
    public static int fib_back3(int index,int cur,int next){
        if (index == 0) return cur;
        else return fib_back3(index-1,next,(cur+next)%mod);
    }


}
