package JZOF.recursion;

/**
 *��LC50��ͬ
 *
 * ������
 */
public class JZ16 {

    public static double myPow1(double x, long n){
        return n>=0 ? quickPow(x,n) : 1.0/quickPow(x,-n);
    }

    public static double quickPow(double x, long n){
        if (n==0)
            return 1.0;
        double temp = quickPow(x, n/2);//��һֱ�ݹ鵽��ײ�
        if (n%2==1)
            return temp*temp*x;
        else
            return temp*temp;
    }
}