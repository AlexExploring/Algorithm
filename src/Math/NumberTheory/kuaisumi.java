package Math.NumberTheory;

public class kuaisumi {

    static int mod = 7;

    public static int fastPow1_1(int a,int n) {
        int res = 1;
        while (n!=0) {
            if ((n&1)==1) //���n�����һλ��1 ��ʾ����ط�����Ҫ��
                res = (a*res)%mod;
            a = (a*a)%mod;
            n>>=1;//n����һλ���Ѹմ���������һλ��n�����һλȥ��
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fastPow1(2, 11));
    }

    public static int fastPow(int a,int n) {
        if (n==1)
            return a;
        int temp = fastPow(a, n/2);
        if (n%2==1)
            return temp*temp*a;
        else
            return temp*temp;
    }

    //λ���������
    public static int fastPow1(int a,int n) {
        int res = 1;
        while (n!=0) {
            if ((n&1)==1) //���n�����һλ��1 ��ʾ����ط�����Ҫ��
                res *= a;
            a*=a;//����˻�
            n>>=1;//n����һλ���Ѹմ���������һλ��n�����һλȥ��
        }
        return res;
    }
}
