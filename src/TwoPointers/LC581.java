package TwoPointers;

import java.util.Arrays;

/**
 * 最短无序连续子数组
 *
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leet-yhlf/
 */
public class LC581 {

    public static void main(String[] args) {
        int [] nums = new int[]{2,6,4,8,10,9,15};
        System.out.println(new LC581().findUnsortedSubarray1(nums));
    }

    /**
     * 方法一: 拷贝一个数组然后排序，然后再与原数组进行比较
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i <= j && nums[i] == arr[i]) i++;
        while (i <= j && nums[j] == arr[j]) j--;
        return j - i + 1;
    }

    /**
     * 方法二: 双指针
     */
    public int findUnsortedSubarray1(int[] nums) {
        //初始化
        int len = nums.length;
        int min = nums[len - 1], max = nums[0];
        int l = 0, r = -1;
        //遍历
        for (int i = 0; i < len; i++) {
            //从左到右维持最大值max,那么在进入右段之前遍历到的nums[i]都是小于max的，
            System.out.println("nums[i]="+nums[i]+"  max="+max);
            if (nums[i] < max) {
                r = i;
                System.out.println(" r="+r);
            } else {
                max = nums[i];
                System.out.println(" max更新："+max);
            }

            //从右到左维持最小值，寻找左边界l
            if (nums[len - 1 - i] > min) {
                l = len - 1 - i;
            } else {
                min = nums[len - 1 - i];
            }
        }
        return r - l + 1;
    }
}
