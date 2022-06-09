package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续列表
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度
 */
public class LC128 {

    /**
     * 先排序，再判断
     */
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;

        Arrays.sort(nums);
        int cur = 1,ans = 1;
        for (int i = 1; i < nums.length; i++) {
            // 相同直接跳过
            if (nums[i] == nums[i-1]) {
                continue;
                // 是否满足连续递增
            }else if (nums[i-1] == nums[i]-1) {
                cur++;
            }else {
                ans = Math.max(cur,ans);
                cur = 1;
            }
        }

        return Math.max(cur,ans);
    }

    /**
     * 使用set存储所有的数字
     */
    public int longestConsecutive1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int ans = 0;
        //如果是遍历nums，在leetcode上提交显示的结果，速度很慢。（不知道为什么）
        for (Integer num : numSet) {
            //确保每一个连续序列都是从最小的数字开始的
            if (!numSet.contains(num-1)) {
                int curNum = num;
                int curAns = 1;
                while (numSet.contains(++curNum)) {
                    curAns += 1;
                }
                ans = Math.max(ans,curAns);
            }
        }

        return ans;
    }
}
