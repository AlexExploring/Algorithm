package DP.climbStairs;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 爬楼梯：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬
 * 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class LC70 {
    
    /**
     * 递推
     * 注意 n >= 1 ; n <= 45
     */
    public int climbStairs(int n){
        int p = 0,q = 1,sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = p+q;
            p = q;
            q = sum;
        }
        return sum;
    }

    /**
     * 递归：超时
     */
    public int climbStairs1(int n) {
        if (n <= 2)
            return n;
        else
            return climbStairs1(n-1)+climbStairs1(n-2);
    }


    HashMap<Integer,Long> map = new HashMap();

    /**
     * 记忆化递归
     */
    public long climbStairs3(int n) {
        if (n<=2)
            return n;
        else {
            if (map.containsKey(n))
                return map.get(n);
            else {
                long m = climbStairs3(n-1)+climbStairs3(n-2);
                map.put(n,m);
                return m;
            }
        }
    }
}
