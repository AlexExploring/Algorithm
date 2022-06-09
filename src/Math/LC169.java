package Math;

import java.util.Arrays;

public class LC169 {

    /**
     * 排序法
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法：
     * 题解：https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
     *
     * 记数组首个元素为 n1众数为 x ，遍历并统计票数。当发生 票数和=0 时，剩余数组的众数一定不变 ，这是由于：
     * 当 n1=x ： 抵消的所有数字中，有一半是众数 x
     * 当 n1!=x : 抵消的所有数字中，众数 x 的数量最少为 0 个，最多为一半。
     */
    public int majorityElement1(int[] nums) {
        int x = 0, votes = 0;

        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }

        return x;
    }
}
