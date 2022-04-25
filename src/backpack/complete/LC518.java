package backpack.complete;

/**
 * ��Ǯ�һ�II ����JZ104���ƣ�
 *
 * ������ӣ�https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-ii-by-leetcode-soluti-f7uh/
 */
public class LC518 {

    /**
     *  ����dp[x] ��ʾ���֮�͵��� xx ��Ӳ���������Ŀ������dp[amount]
     *
     *  ע�⣺���������ظ����㲻ͬ�����С���Ϊ���ѭ���Ǳ�������coins ��ֵ��
     *  �ڲ�ѭ���Ǳ�����ͬ�Ľ��֮�ͣ��ڼ��� dp[i] ��ֵʱ������ȷ�����֮��
     *  ���� i��Ӳ������˳������˳��ȷ������˲����ظ����㲻ͬ�����С�
     *  ���Ӽ�ͼƬ
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}