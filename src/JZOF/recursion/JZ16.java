package JZOF.recursion;

/**
 *和LC50相同
 *
 * 快速幂
 */
public class JZ16 {

    public static double myPow1(double x, long n){
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