package a_basic_Operation;

public class code {
    /**
     *判断是否是闰年
     */
    static boolean isLeap(int year) { // 闰年：2月29天；平年：2月28天
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }


    /**
     *求最大公因数
     */
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    /**
     *求最大公倍数
     */
    public static int commonMultiples(int a,int b){
        int t = gcd(a,b);
        return (a*b)/t;
    }

    /**
     *扩展欧几里得：任意两个数，互质；不能凑出来的最大数：a×b-a-b
     */
}
