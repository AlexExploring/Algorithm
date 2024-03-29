package DP.matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LC62不同路径，相关题目LC63，不同路径II
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 */


public class LC62 {

    public static void main(String[] args) {
        System.out.println(new LC62().uniquePaths(6, 6));
    }

    /**
     *动态规划
     */
    public int uniquePaths(int m,int n){
        int [][] dp = new int[m][n];

        //在第一行 只有从左向右一种走法
        for (int i=0;i<n;i++){
            dp[0][i]=1;
        }
        //第一列 只有从上到下一种走法
        for (int i=0;i<m;i++){
            dp[i][0]=1;
        }

        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    /**
     * 优化
     * 时间复杂度：O(mn)。
     *
     * 空间复杂度：O(mn)，即为存储所有状态需要的空间。注意到 f(i, j)
     * 仅与第 i 行和第 i-1 行的状态有关，因此我们可以使用滚动数组代替代码中的
     * 二维数组，使空间复杂度降低为 O(n)。此外，由于我们交换行列的值并不会对答
     * 案产生影响，因此我们总可以通过交换 m 和 n 使得 m≤n，这样空间复
     * 杂度降低至 O(min(m,n))。
     */
    public int uniquePaths1(int m,int n){
        int [] dp = new int[n];

        //处理第一行
        Arrays.fill(dp,1);

        for (int i = 1;i < m;i++){
            for (int j = 1;j < n;j++){
                dp[j] = dp[j] + dp[j-1];
            }
        }

        return dp[n-1];
    }

    /**
     *递归
     */
    public int uniquePaths2(int m, int n) {
        return uniquePathsHelper(1, 1, m, n);
    }

    //第i行第j列到第m行第n列共有多少种路径
    public static int uniquePathsHelper(int i, int j, int m, int n) {
        //边界条件的判断
        if (i > m || j > n)
            return 0;
        if (i == m && j == n)
            return 1;
        //从右边走有多少条路径
        int right = uniquePathsHelper(i + 1, j, m, n);
        //从下边走有多少条路径
        int down = uniquePathsHelper(i, j + 1, m, n);
        //返回总的路径
        return right + down;
    }

    /**
     *记忆化递归
     *
     *避免重复计算 见 LC62.png
     */
    public int uniquePaths3(int m, int n) {
        return uniquePathsHelper1(1, 1, m, n,new HashMap<>());
    }

    public int uniquePathsHelper1(int i, int j, int m, int n, Map<String,Integer> map) {
        //边界条件的判断
        if (i > m || j > n)
            return 0;
        if (i == m && j == n)
            return 1;
        String key = i+"*"+j;
        if (map.containsKey(key))
            return map.get(key);
        int down = uniquePathsHelper1(i,j+1,m,n,map);
        int right = uniquePathsHelper1(i+1,j,m,n,map);
        int total = right + down;
        map.put(key, total);
        return total;
    }

    /**
     *组合数学
     */
    public int uniquePaths4(int m,int n){
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
