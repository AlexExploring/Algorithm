package DP.buyStock;

/**
 * ���������Ʊʱ�����䶳��
 *
 * ע�⣺�ɶ��������������Ʊ���޷��ڵڶ������루�䶳�ڣ�
 */
public class LC309 {

    /**
     * ��̬�滮
     *
     * ������ f[i]��ʾ�� i �����֮��ġ��ۼ�������桹��������Ŀ�����������������ֻ
     * ��ͬʱ���루���У�һ֧��Ʊ������������Ʊ�����䶳�ڵ����ƣ�������ǻ������ֲ�ͬ��״̬��
     * 1. ����Ŀǰ����һ֧��Ʊ����Ӧ�ġ��ۼ�������桹��Ϊ f[i][0]��
     * 2. ����Ŀǰ�������κι�Ʊ�����Ҵ����䶳���У���Ӧ�ġ��ۼ�������桹��Ϊ f[i][1]��
     * 3. ����Ŀǰ�������κι�Ʊ�����Ҳ������䶳���У���Ӧ�ġ��ۼ�������桹��Ϊ f[i][2]��
     *
     * ��⣺https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;

        if (len == 0) return 0;

        int [][] f = new int[len][3];
        //�ڵ� 0��ʱ��������й�Ʊ����ôֻ�����ڵ� 0 ������ģ���Ӧ������ -prices[0];
        f[0][0] = -prices[0];

        for (int i = 0; i < len; i++) {
            f[i][0] = Math.max(f[i-1][0],f[i-1][2]-prices[i]);
            f[i][1] = f[i-1][0] + prices[i];
            f[i][2] = Math.max(f[i-1][1],f[i-1][2]);
        }
        return Math.max(f[len-1][1],f[len-1][2]);
    }
}
