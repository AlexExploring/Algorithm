package JZOF.array;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class JZ21 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange2(new int[]{1,2,3,4,5})));
    }


    /**
     * 2ms
     */
    public static int[] exchange(int[] nums) {
        int [] ans = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2!=0){
                ans[index++] = nums[i];
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                ans[index++] = nums[i];
            }
        }
        return ans;
    }

    /**
     * 6ms
     */
    public static int[] exchange1(int[] nums) {
        Deque<Integer> queue = new LinkedList();
        for (int i = 0; i < nums.length;i++) {
            if (nums[i]%2!=0)
                queue.offerFirst(nums[i]);
            else queue.offerLast(nums[i]);
        }
        int [] ans = new int[nums.length];
        int index = 0;
        while(!queue.isEmpty()){
            ans[index++] = queue.poll();
        }
        return ans;
    }


    /**
     * 双指针 1ms
     */
    public static int[] exchange2(int[] nums) {
        int left = 0, right = nums.length-1;
        while (left < right && left<nums.length && right>0) {
            if ((nums[left] & 1) != 0) {
                left ++;
                continue;
            }
            if ((nums[right] & 1) != 1) {
                right --;
                continue;
            }
            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;
            left++;right++;
        }
        return nums;
    }


    /**
     * 快慢双指针 2ms
     */
    public int[] exchange3(int[] nums) {
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] % 2 == 1){
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
