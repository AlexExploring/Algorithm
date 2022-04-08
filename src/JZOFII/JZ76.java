package JZOFII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数组中第K大的数字
 *
 * 和LC215相同
 */
public class JZ76 {

    /**
     * 排序
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 快速排序
     */
    public int findKthLargest1(int[] nums, int k) {

        return 0;
    }


    /**
     * 使用优先队列
     */
    public int findKthLargest2(int[] nums, int k) {
        //建立一个大小为k的大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : nums) {
            queue.offer(num);
        }

        while (k != 1) {
            queue.poll();
            k--;
        }

        return queue.peek();
    }
}