package DP;

import java.util.Scanner;

/**
 * @author zhxspacex
 * @date 2020/12/24 10:29
 */
public class shuzisanjiaoxing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] map = new int[n+1][];
        int [][] maxSum = new int[n+1][];
        //输入图
        for (int i = 1; i <= n; i++) {
            map[i] = new int[i+1];
            maxSum[i] = new int[i+1];
            for (int j = 1; j <= map[i].length-1; j++) {
                map[i][j] = scanner.nextInt();
                maxSum[i][j] = -1;
            }
        }
        //int ans = getMax(map,1,1,n);
        int ans = getMax1(map,maxSum,1,1,n);
        //int ans = getMax2(map,maxSum,n);
        System.out.print(ans);

    }

    /**
     *递归
     *
     * 自底向上的递归
     */
    public static int getMax(int[][] map,int i,int j,int n){

        if (i == n) return map[i][j];
        int x = getMax(map,i+1,j,n);
        int y = getMax(map,i+1,j+1,n);
        //边界在顶部，假如当前行i即为n-1,则需要选出两种可能中的最大值，即为从(1,1)到(n,x)
        //的最大值，这样在从顶部到底部的时候，就选出了从顶部到底部的最大值。
        return Math.max(x,y)+map[i][j];
    }

    /**
     *记忆化递归
     * 降低时间复杂度
     */
    public static int getMax1(int[][] map,int [][] maxSumm,int i,int j,int n){
        if (maxSumm[i][j] != -1)
            return maxSumm[i][j];
        if (i == n) return map[i][j];
        else {
            int x = getMax(map,i+1,j,n);
            int y = getMax(map,i+1,j+1,n);
            //边界在顶部，假如当前行i即为n-1,则需要选出两种可能中的最大值，即为从(1,1)到(n,x)
            //的最大值，这样在从顶部到底部的时候，就选出了从顶部到底部的最大值。
            maxSumm[i][j] = Math.max(x,y)+map[i][j];
        }
        return maxSumm[i][j];
    }

    /**
     *递归一般情况下都可以转化为递推
     */
    public static int getMax2(int [][] map,int [][] maxSum,int n){
        for (int i = 1; i <= n; i++) {
            maxSum[n][i] = map[n][i]; //maxSum指向第n行
        }
        for (int i = n-1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                //由下一行推出上一行，直到推出第一行第一列
                maxSum[i][j] = Math.max(maxSum[i+1][j],maxSum[i+1][j+1])+map[i][j];
            }
        }
        return maxSum[1][1];
    }
}

