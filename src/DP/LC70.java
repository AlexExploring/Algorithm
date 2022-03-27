package DP;

/**
 * @author zhxspacex
 * @date 2020/12/15 18:49
 */
/**
 *爬楼梯
 */

import java.util.HashMap;
import java.util.Scanner;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

/**
 *DP可以用递归和迭代的方式实现
 */
public class LC70 {
    static HashMap<Integer,Long> map = new HashMap();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(climbStairs2(n));
    }

    /**
     *递推
     */
    public static int climbStairs(int n){
        int p = 0,q = 1,sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = p+q;
            p = q;
            q = sum;
        }
        return sum;
    }

    /**
     *递推
     */
    public static int climbStairs1(int n) {
        int p = 0,q = 0,r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }

    /**
     *递归：超时
     */
    public static int climbStairs2(int n) {
        if (n <= 2)
            return n;
        else
            return climbStairs2(n-1)+climbStairs2(n-2);
    }

    /**
     *记忆化递归
     */
    public static long climbStairs3(int n) {
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
