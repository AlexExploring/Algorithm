package BinarySearch;

/**
 *pow(x,n)  x可以是小数
 */
public class LC50 {
    public static void main(String[] args) {
        System.out.println(myPow(2,-3));
    }

    //快速幂运算  位运算   如果不用一个long值来存储n， 则 如果n为 -2^31 则，n=-n会超出int的表示范围
    //导致判题超时甚至错误
    public static double myPow(double x, int n){
        double res = 1,flag = 1;
        long b = n;
        if (b<0){
            b = -b;flag=0;
        }
        while (b!=0) { // 二进制运算
            if ((b&1)==1) //如果n的最后一位是1 表示这个地方还需要乘
                res *= x;
            x*=x;//推算乘积
            b>>=1;//n右移一位，把刚处理过的最后一位的n的最后一位去掉
        }
        if (flag==0) return 1.0/res;
        return res;
    }

    /**
     *Leetcode 耗时 1ms
     */
    public static double myPow1(double x, int n){
        if (x==0) return 0;
        long b = n;
        double res = 1.0;
        if (b<0){
            x = 1/x;
            b = -b;
        }

        while (b!=0){
            if ((b&1) == 1) res*=x;
            x*=x;
            b>>=1;
        }
        return res;
    }

    /**
     *-100.0 < x < 100.0
     * -2^31 <= n <= 2^31-1
     * -10^4 <= x^n <= 10^4
     *
     * 原题中的n的类型为int，但是对于n 如果取-2^31,会超过int能够表达的最大值
     * 这里直接修改参数的类型，或者在题目中将n转化为long值
     *
     *计算x^77
     * x->x^2->x^4->x^9->x^19->x^38->x^77
     */
    public static double myPow2(double x, long n){
        return n>=0 ? quickPow(x,n) : 1.0/quickPow(x,-n);
    }

    public static double quickPow(double x, long n){
        if (n==0)
            return 1.0;
        double temp = quickPow(x, n/2);//先一直递归到最底层
        if (n%2==1)
            return temp*temp*x;
        else
            return temp*temp;
    }
}