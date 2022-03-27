package recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//问题2： 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
//求该青蛙跳上一个n级的台阶总共有多少种跳法。
//分析，其实这道题和上面那道题一样的，只是本来每次跳有两种选择，现在有n
//种选择，即f(n) = f(n-1) + f(n - 2) + f(n-3)+.....+f(1);
public class natalie2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(solve4(n));
    }

    public static int solve4(int n){
        Map<Integer, Integer> map = new HashMap<>();
        if (n<=2)
            return n;
        else {
            if (map.containsKey(n)){//查看是否存在
                return map.get(n);
            } else {//如果不存在则递归计算
                int m = 0;
                for (int i = 1;i<=n;i++){
                    n += solve4(n-i);
                }
                map.put(n,m);
                return m;
            }
        }
    }
}
