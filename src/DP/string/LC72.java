package DP.string;

/**
 * 编辑距离
 *
 * 问题：给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 思路：你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 一旦涉及子问题，可以用自顶向下的递归和自底向上的动态规划
 */
public class LC72 {

    /**
     * dp[i][j]表示当字符串word1的长度为i。字符串word2的长度为j时，
     * 将word1转化为word2所使用的最少操作次数为dp[i][j];
     */
    public static int minDistance(String word1,String word2){
        int n1 = word1.length(),n2 = word2.length();

        int[][] dp = new int[n1+1][n2+1];

       //初始化 如果i或j两者中其中一个为零(为0即为空字符串 "")，则对word1一直执行删除操作或一直执行插入操作，且此时不能使用该关系式
        for (int j = 1;j <= n2;j++){
            dp[0][j] = dp[0][j-1]+1;
        }
        for (int i = 1;i <= n1;i++){
            dp[i][0] = dp[i-1][0]+1;
        }

        //将从0-i的字符转换成0-j的字符
        for (int i = 1;i <= n1;i++){
            for (int j = 1;j <= n2;j++){
                //如果word1[i]和word2[j]相等，第i个字符对应下标是i-1;
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    //分别是替换，插入，删除操作。
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                }

                //所有的操作都是针对word1
                //插入操作:将word2[j]插入到word1[i]末尾，然后word2[j]和word1[i+1]抵消，则只需比较dp[i][j-1]
            }
        }

        return dp[n1][n2];
    }
}
