package Math.factor;

import java.util.Scanner;

/**
 *质因数分解
 *
 * 已知正整数 n 是两个不同的质数的乘积，试求出较大的那个质数。
 *
 * 输入格式
 * 输入只有一行，包含一个正整数 n。
 *
 * 输出格式
 * 输出只有一行，包含一个正整数 p，即较大的那个质数。
 *
 * 数据范围
 * 6≤n≤2?109
 *
 *
 * 所有约数都是成对出现的：如果 d 是 n 的约数，那么 n/d 也是 n 的约数。
 *
 * 我们可以只枚举较小的约数，然后计算出较大的约数即可。那么需要枚举的范围满足： d≤n/d，则 d≤√n。因此只需要枚举 √n 次。
 */
public class ac_449 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(getMaxPrimeFactor(scan.nextInt()));
    }

    public static int getMaxPrimeFactor(int n){
        int ans = 0;
        //for (int i = 2;; i ++ )
        for (int i = 2;i<=Math.sqrt(n); i ++ ){
            if (n % i == 0) {
                ans = n/i;
                break;
            }
        }
        return ans;
    }
}
