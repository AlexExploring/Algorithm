package binarySearchTree;

/**
 * ��ͬ�Ķ���������
 */
public class LC96 {

    /**
     * ������ӣ�https://leetcode.cn/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/
     *
     *  n ���ڵ���ڶ����������ĸ����� dp[n]
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}