package TwoPointers.array;

/**
 * 题目：两数之和II
 * 
 * 给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，
 * 请你从数组中找出满足相加之和等于目标数target 的两个数。如果设这两个数
 * 分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class LC167 {

    /**
     * 双重循环，暴力枚举
     */
    public int[] twoSum(int[] numbers, int target) {
        int [] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    ans[0] = i + 1;ans[1] = j + 1;
                }
            }
        }

        return ans;
    }

    /**
     * 双指针
     */
    public int[] twoSum1(int[] numbers, int target) {
        int l = 0,r = numbers.length - 1,sum;
        while (l < r) {
            sum = numbers[l] + numbers[r];
            if (sum > target) r--;
            else if (sum < target) l++;
            else {
                //如果下表从0开始，则left和right都不需要加1
                return new int[]{l + 1,r + 1};
            }
        }

        return new int[0];
    }
}