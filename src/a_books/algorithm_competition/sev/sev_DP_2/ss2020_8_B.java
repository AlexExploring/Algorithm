package a_books.algorithm_competition.sev.sev_DP_2;

/**
 * DP推导+奇偶判断。
 * 在输入数组的时候进行数组值的计算，因为只能向左或者右走，即我现在所在的位置坐标是从上一
 * 层这个位置的左边或者上边进行跳转得到的坐标，通过选择最大值进行跳转，更新数组的值
 * 由于向左向右不能超过1，所以通过奇偶判断层数，
 * 如果是奇数，最后的位置第n层，第（n/2+1）位置上的数字
 * 如果是偶数，则需要判断第n层，第（n/2）位置的数字和第n层第（n/2+1）位置的数字，选大的。
 * 注意我的数组下标是从1开始。*/
import java.util.Scanner;
public class ss2020_8_B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = sc.nextInt();
                arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(arr[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println(n % 2 == 1 ? arr[n][n / 2 + 1] : Math.max(arr[n][n / 2], arr[n][n / 2 + 1]));
    }
}