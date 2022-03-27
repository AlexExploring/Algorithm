package Math.NumberTheory;

public class kuaisumi {

    static int mod = 7;

    public static int fastPow1_1(int a,int n) {
        int res = 1;
        while (n!=0) {
            if ((n&1)==1) //如果n的最后一位是1 表示这个地方还需要乘
                res = (a*res)%mod;
            a = (a*a)%mod;
            n>>=1;//n右移一位，把刚处理过的最后一位的n的最后一位去掉
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

    //位运算快速幂
    public static int fastPow1(int a,int n) {
        int res = 1;
        while (n!=0) {
            if ((n&1)==1) //如果n的最后一位是1 表示这个地方还需要乘
                res *= a;
            a*=a;//推算乘积
            n>>=1;//n右移一位，把刚处理过的最后一位的n的最后一位去掉
        }
        return res;
    }
}
