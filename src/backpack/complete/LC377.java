package backpack.complete;

/**
 * ����ܺ�IV (��LC518��Ǯ�һ�II����(���ⲻ��Ҫ����˳��))
 *
 * ������ӣ�https://leetcode.cn/problems/D0F0SV/solution/tong-guan-jian-2-shuang-bai-bei-bao-dp-b-f33v/
 */
public class LC377 {

    /**
     * ע�⣺�������ֳ��ֵĴ�����ͬ������˳��ͬ�����б�������ͬ�����
     * <p>
     * ����dp[x] ��ʾѡȡ��Ԫ��֮�͵��� x �ķ�������Ŀ������dp[target]
     * <p>
     * ע��:�����Ƿ��ǵ�ѡȡԪ�ص�˳�򣿴��ǿ϶��ġ���Ϊ���ѭ���Ǳ�����
     * 1 �� target ��ֵ���ڲ�ѭ���Ǳ������� nums ��ֵ���ڼ���dp[i] ��ֵʱ��
     * nums �е�ÿ��С�ڵ��� i ��Ԫ�ض�������ΪԪ��֮�͵��� i �����е����һ
     * ��Ԫ�ء����磬1 �� 3 ��������nums �У�����dp[4] ��ʱ�����е����һ
     * ��Ԫ�ؿ����� 1 Ҳ������ 3�����dp[1] ��dp[3] ���ᱻ���ǵ�������ͬ��˳
     * �򶼻ᱻ���ǵ���
     */
    public int combinationSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        //ֻ�е���ѡȡ�κ�Ԫ��ʱ��Ԫ��֮�Ͳ�Ϊ 0�����ֻ�� 1 �ַ���
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    /**
     * �������ֳ��ֵĴ�����ͬ��˳��ͬ�����б�������ͬ�����
     */
    public int combinationSum1(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = num; i <= target; i++) {
                dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}
