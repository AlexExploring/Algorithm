package DP.matrix;

import java.io.*;
import java.util.Scanner;

/**
 * 最大正方形
 * 相似题目：LC1277
 */
public class LC221 {

    /**
     *暴力循环
     */
    public static int maximalSquare(char [][] matrix){
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return maxSide;

        int rows = matrix.length,cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1'){
                    //遇到一个1作为左上角
                    maxSide = Math.max(maxSide,1);
                    //计算可能的最大的正方形的边长，即是从当前点起的边界
                    int currentMaxSide = Math.min(rows-i,cols-j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        //判断新增的从左上角到左下角是否为0
                        boolean flag = true;
                        if (matrix[i+k][j+k] == '0')
                            break;

                        for (int l = 0; l < k; l++) {
                            //分别判断新增的行和列
                            if (matrix[i+k][j+l] == '0' || matrix[i+l][j+k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        //通过所有的测试，
                        if (flag)
                            maxSide = Math.max(maxSide,k+1);
                        else
                            break;;
                    }

                }
            }
        }
        int maxSquare = maxSide*maxSide;
        return maxSquare;
    }

    public static int maximalSquare1(char [][] matrix){
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return maxSide;
        int rows = matrix.length,cols = matrix[0].length;

        int [][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0) //处理边界
                        dp[i][j] = 1;
                    else {
                        //核心
                        dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide*maxSide;
        return maxSquare;
    }

    public static int maximalSquare2(char [][] matrix){
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return maxSide;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int [] dp = new int[cols+1];
        int max = 0,pre = 0;
        for (int i = 1; i <= rows; i++) {  //利用一维数组优化，则外层循环仅仅只是计数
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(Math.min(dp[j-1],pre),dp[j])+1;
                    max = Math.max(max,dp[j]);
                }else {
                    dp[j] = 0;
                }
                pre = temp;
            }
            for (int k = 0; k <= cols; k++) {
                System.out.print(dp[k]+" ");
            }
            System.out.println();
        }
        return max*max;
    }
}
