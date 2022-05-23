package DP.climbStairs;

import java.util.HashMap;

/**
 * 쳲��������� ��LC70������ ��һ����
 */
public class JZ10 {


    /**
     * n >= 0;n <= 100
     * fib(0) = 0;
     * fib(1) = 1;
     */
    public int fib(int n) {
        if (n < 2) return n;

        final int MOD = 1000000007;
        int p = 0, q = 0, r = 1;

        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            //�ڵ��ƵĹ����У��Խ��ȡģ����ֹ���
            r = (p + q) % MOD;
        }

        return r;
    }

    /**
     * �ݹ飬�ᳬʱ
     */
    public static int fib1(int n){
        if (n < 2) return n;
        else return (fib1(n-1)+fib1(n-2))%1000000007;
    }

    /**
     * ���仯�ݹ�
     */
    HashMap<Integer,Integer> map = new HashMap();
    public int fib3(int n){
        if (n == 0) return 0;
        else if (n<=2) return 1;
        else {
            if (map.containsKey(n)) return map.get(n);
            else {
                int temp = (fib3(n-1)+ fib3(n-2))%1000000007;
                map.put(n,temp);
                return temp;
            }
        }
    }
}
