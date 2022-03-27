package recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//题目1：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
public class njitaijie {
    static Map<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(solve(n));
        System.out.println(solve2(n));
        System.out.println(solve3(n));
    }

    public static int solve(int n){
        if (n <= 2){
            return n;
        }
        else
            return solve(n-1)+solve(n-2);
    }

    //动态规划   记忆化搜索
    //因此对于那些重复算过的，其实我们可以不用在重复递归来算它的，也就是所我们可以把f(n)
    // 算的结果一边给保存起来，这种就是动态规划的思想。
    //也就是说，我们可以把每次计算的结果保存中一个map容器里，把n作为key,f(n)作为value
    // .然后每次要递归的时候，先查看一下这个f(n)我们是否已经算过了，如果已经算过了，我们直接从map容器里取出来返回去就可以了。
    public static long solve2(int n){
        if (n<=2)
            return n;
        else {
            if (map.containsKey(n)){//查看是否存在
                return map.get(n);
            }
            else {//如果不存在则递归计算
                long m = solve2(n-1)+solve2(n-2);
                map.put(n,m);
                return m;
            }
        }
    }

    //动态规划  递推关系  下一个状态只和前两个连续的状态有关 所以可以采用双指针方式，将空间复杂度降到O(1)级别
    public static long solve3(int n){
        if (n <= 2)
            return n;
        long f1=0,f2=1;
        long sum = 0;
        for (int i=1;i<=n;i++){
            sum = f1+f2;
            f1=f2;
            f2=sum;
        }
        return sum;
    }
}
