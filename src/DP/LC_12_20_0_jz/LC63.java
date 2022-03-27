package DP.LC_12_20_0_jz;

import java.util.Scanner;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class LC63 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int [][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        System.out.println(uniquePathsWithObstacles(a));
    }

    /**
     *不知道在哪看到的，答案有误
     */
    public static int uniquePathsWithObstacles(int [][] obstacleGrid){
        if (obstacleGrid.length==0||obstacleGrid[0].length==0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int[m][n];

        //第一行全为障碍物，则为0
        int flag = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    flag++;
            }
            if (flag == n) return 0;
            else flag = 0;
        }

        //从左上到左下全为障碍物，则为0
        flag = 0;
        for (int i = 0,j=0; i < n; i++) {
            while (j < m){
                if (obstacleGrid[j][i] == 1)
                    flag++;j++;
            }
            if (flag == m) return 0;
            else flag=0;
        }

        //从左上角无法到达下一步，无法到达右下角
        if (m >= 2 && n >= 2){
            int t = 0;
            if ((obstacleGrid[0][1]==1&&obstacleGrid[1][0]==1)||
                    (obstacleGrid[m-2][n-1]==1&&obstacleGrid[m-1][n-2]==1)){
                t=1;
            }
            return 0;
        }

        //左上角的值为障碍物或则目标地为障碍物
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;
        else {
            //初始化
            for (int i=0;i<m;i++){
                if (obstacleGrid[i][0] == 1)
                    dp[i][0]=0;
                else
                    dp[i][0]=1;
            }
            //初始化
            for (int j=0;j<n;j++){
                if (obstacleGrid[0][j] == 1)
                    dp[0][j]=0;
                else
                    dp[0][j]=1;
            }

            //核心
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        if (m >= 2 && n >= 2){
            int t = 0;
            if ((obstacleGrid[0][1]==1&&obstacleGrid[1][0]==1)||
                    (obstacleGrid[m-2][n-1]==1&&obstacleGrid[m-1][n-2]==1)){
                t=1;
            }
            return 0;
        }


        return dp[m-1][n-1];
    }
}
