package slidingWindow;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Exercise {

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];

        //����һ���ڲ��Ƚ���
        Queue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                //���ݶ�Ӧ�ıȽ�����������õ����Ǵ���ѣ���ֵ��ȵ�ʱ�򣬱���Ҫ�����±�������
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
            //�Ѷ���һ�������ֵ������Ҫ�ж��Ƿ��ڴ�����
            while (pq.peek()[1] <= i-k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }

        return ans;
    }
}