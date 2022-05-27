package BitManipulation.numbersThatAppearOnlyOnce;

/**
 * 题目：给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 和JZ56I相同
 */
public class LC260 {
    /**
     * 异或运算
     * 1. 两个相同的数的异或结果为0
     * 2. 任何数和0异或的结果为它本身
     *
     * 官方题解：https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-by-leetcode/
     */
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }

        //得到ret最低位为1的数div，
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int n : nums) {
            //根据特定的位将nums中的数子划分为两部分
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }

        return new int[]{a, b};
    }
}
