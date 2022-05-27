package BitManipulation.numbersThatAppearOnlyOnce;

/**
 * ��Ŀ������һ���������� nums������ǡ��������Ԫ��ֻ����һ�Σ���������Ԫ�ؾ��������Ρ� �ҳ�ֻ����һ�ε�������Ԫ�ء�
 *
 * ��JZ56I��ͬ
 */
public class LC260 {
    /**
     * �������
     * 1. ������ͬ�����������Ϊ0
     * 2. �κ�����0���Ľ��Ϊ������
     *
     * �ٷ���⣺https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/
     */
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }

        //�õ�ret���λΪ1����div��
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int n : nums) {
            //�����ض���λ��nums�е����ӻ���Ϊ������
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }

        return new int[]{a, b};
    }
}
