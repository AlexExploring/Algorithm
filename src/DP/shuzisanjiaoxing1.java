package DP;

import java.util.Scanner;

public class shuzisanjiaoxing1{
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int n = scan.nextInt();
        int [][] map = new int[n+1][n+1];
        int [] maxSum;
        //输入图
        for (int i = 1; i <= n; i++) {
            map[i] = new int[i+1];
            for (int j = 1; j <= map[i].length-1; j++) {
                map[i][j] = scan.nextInt();
            }
        }

        System.out.print(getMax3(map,n));
    }

    /**
     * 递推
     *
     *空间优化，由于上一行的结果之和下一行的结果有关，所以可以只保存一行结果
     * 将maxSum的空间复杂度优化为O(n)
     */
    public static int getMax3(int [][] map,int n){
        int [] maxSum = map[n];
        for (int i = n-1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                //由下一行推出上一行，直到推出第一行第一列
                maxSum[j] = Math.max(maxSum[j],maxSum[j+1])+map[i][j];
            }
        }
        return maxSum[1];
    }
}