package JZOF.recursion;

import java.util.HashMap;
import java.util.Scanner;

/**
 *青蛙跳台阶问题
 */
public class JZ10_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(numWays(scan.nextInt()));
    }


    static int mod = ((int) Math.pow(10,9))+7;

    public static int numWays(int n) {
        if (n == 0) return 1;
        return recursion2(n);
    }

    /**
     *暴力递归，超出时间限制
     */
    public static int recursion(int n){
        if (n<=1) return n;
        else if (n==2) return 2;
        else return (recursion(n-1)+recursion(n-2))%mod;
    }

    /**
     *记忆化递归
     */
    static HashMap<Integer,Integer> map = new HashMap();
    public static int recursion2(int n){
        if (n<=1) return n;
        else if (n==2) return 2;
        else {
            if (map.containsKey(n)) return map.get(n);
            else {
                int temp = (recursion2(n-1)+recursion2(n-2))%mod;
                map.put(n,temp);
                return temp;
            }
        }
    }
}
