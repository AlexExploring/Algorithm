package slidingWindow;

import java.util.*;

/**
 * 滑动窗口的最大值
 */
public class LC239 {

    /**
     * 如果直接使用双重for循环的话对于每个滑动窗口，我们可以使用 O(k)
     * 的时间遍历其中的每一个元素，找出其中的最大值。对于长度为 n 的数组
     * nums 而言，窗口的数量为 n-k+1，因此该算法的时间复杂度为
     * O((n-k+1)k)=O(nk)，会超出时间限制，因此我们需要进行一些优化。
     */

    /**
     * 使用优先队列
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];

        //传入一个内部比较器
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                //根据对应的比较器规则，这里得到的是大根堆，（值相等的时候，必须要根据下标再排序）
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });

        //先记录第一个窗口中所有的值
        //记录的值是一个二元组 分别是元素的 值和元素在数组中对应的下标
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        //用来存放结果，一共有(len-k+1)个窗口
        int[] ans = new int[len - k + 1];
        //取出第一个值
        ans[0] = pq.peek()[0];

        // 我们只需要判断 优先队列中对应的最大值的下标是否在 这个窗口中，如果在，则这个窗口中的最大值
        // 就是优先队列的顶点对应的值，
        for (int i = k; i < len; ++i) {
            pq.offer(new int[]{nums[i], i});
            //最大值对应的下标不在窗口中，则将当前的最大值从优先队列中删除
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            //将当前窗口的最大值放入结果中
            ans[i - k + 1] = pq.peek()[0];
        }

        return ans;
    }

    /**
     * 使用单调队列
     *
     * 在这个队列中，里面存储的是下标，这些下标按照从小到大的顺序被存储，
     * 并且他们在数组nums中对应的值是严格单调递减的。（会从队列的左端得到窗口中的最大值）
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];

        Deque<Integer> queue = new LinkedList<Integer>();
        //先将前k个数放入队列
        for (int i = 0; i < k; ++i) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        int[] ans = new int[len - k + 1];
        //队首存储的下标就是对应窗口中的最大值对应的下标
        ans[0] = nums[queue.peekFirst()];

        for (int i = k; i < len; ++i) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            //添加新元素
            queue.offerLast(i);
            //如果队首不在窗口内，则将队首弹出
            while (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            //此时nums[queue.peekFirst()]一定是窗口中的最大值
            ans[i - k + 1] = nums[queue.peekFirst()];
        }

        return ans;
    }
}