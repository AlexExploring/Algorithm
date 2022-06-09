package slidingWindow;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Exercise {

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];

        //传入一个内部比较器
        Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                //根据对应的比较器规则，这里得到的是大根堆，（值相等的时候，必须要根据下标再排序）
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });

        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i],i});
        }

        int[] ans = new int[len - k + 1];
        ans[0] = pq.peek()[0];

        for (int i = k; i < len; i++) {
            pq.offer(new int[]{nums[i],i});
            //堆顶的一定是最大值，但需要判断是否在窗口中
            while (pq.peek()[1] <= i-k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }

        return ans;
    }
}