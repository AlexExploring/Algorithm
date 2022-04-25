package JZOFII;

/**
 * ���е���Ŀ ����LC377��ͬ������ܺ�IV��
 *
 * ��LC518��Ǯ�һ�II����(���ⲻ��Ҫ����˳��)
 */
public class JZ104 {

    /**
     * ע�⣺˳��ͬ�����б�������ͬ�����
     *
     * ����dp[x] ��ʾѡȡ��Ԫ��֮�͵��� x �ķ�������Ŀ������dp[target]
     *
     * ע��:�����Ƿ��ǵ�ѡȡԪ�ص�˳�򣿴��ǿ϶��ġ���Ϊ���ѭ���Ǳ�����
     * 1 �� target ��ֵ���ڲ�ѭ���Ǳ������� nums ��ֵ���ڼ���dp[i] ��ֵʱ��
     * nums �е�ÿ��С�ڵ��� i ��Ԫ�ض�������ΪԪ��֮�͵��� i �����е����һ
     * ��Ԫ�ء����磬1 �� 3 ��������nums �У�����dp[4] ��ʱ�����е����һ
     * ��Ԫ�ؿ����� 1 Ҳ������ 3�����dp[1] ��dp[3] ���ᱻ���ǵ�������ͬ��˳
     * �򶼻ᱻ���ǵ���
     */
    public int combinationSum4(int[] nums, int target) {
        int [] dp = new int[target+1];
        //ֻ�е���ѡȡ�κ�Ԫ��ʱ��Ԫ��֮�Ͳ�Ϊ 0�����ֻ�� 1 �ַ���
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}