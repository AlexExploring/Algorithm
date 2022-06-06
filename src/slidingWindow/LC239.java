package slidingWindow;

import java.util.*;

/**
 * �������ڵ����ֵ
 */
public class LC239 {

    /**
     * ���ֱ��ʹ��˫��forѭ���Ļ�����ÿ���������ڣ����ǿ���ʹ�� O(k)
     * ��ʱ��������е�ÿһ��Ԫ�أ��ҳ����е����ֵ�����ڳ���Ϊ n ������
     * nums ���ԣ����ڵ�����Ϊ n-k+1����˸��㷨��ʱ�临�Ӷ�Ϊ
     * O((n-k+1)k)=O(nk)���ᳬ��ʱ�����ƣ����������Ҫ����һЩ�Ż���
     */

    /**
     * ʹ�����ȶ���
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];

        //����һ���ڲ��Ƚ���
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                //���ݶ�Ӧ�ıȽ�����������õ����Ǵ���ѣ���ֵ��ȵ�ʱ�򣬱���Ҫ�����±�������
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });

        //�ȼ�¼��һ�����������е�ֵ
        //��¼��ֵ��һ����Ԫ�� �ֱ���Ԫ�ص� ֵ��Ԫ���������ж�Ӧ���±�
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        //������Ž����һ����(len-k+1)������
        int[] ans = new int[len - k + 1];
        //ȡ����һ��ֵ
        ans[0] = pq.peek()[0];

        // ����ֻ��Ҫ�ж� ���ȶ����ж�Ӧ�����ֵ���±��Ƿ��� ��������У�����ڣ�����������е����ֵ
        // �������ȶ��еĶ����Ӧ��ֵ��
        for (int i = k; i < len; ++i) {
            pq.offer(new int[]{nums[i], i});
            //���ֵ��Ӧ���±겻�ڴ����У��򽫵�ǰ�����ֵ�����ȶ�����ɾ��
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            //����ǰ���ڵ����ֵ��������
            ans[i - k + 1] = pq.peek()[0];
        }

        return ans;
    }

    /**
     * ʹ�õ�������
     *
     * ����������У�����洢�����±꣬��Щ�±갴�մ�С�����˳�򱻴洢��
     * ��������������nums�ж�Ӧ��ֵ���ϸ񵥵��ݼ��ġ�����Ӷ��е���˵õ������е����ֵ��
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return new int[0];

        Deque<Integer> queue = new LinkedList<Integer>();
        //�Ƚ�ǰk�����������
        for (int i = 0; i < k; ++i) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        int[] ans = new int[len - k + 1];
        //���״洢���±���Ƕ�Ӧ�����е����ֵ��Ӧ���±�
        ans[0] = nums[queue.peekFirst()];

        for (int i = k; i < len; ++i) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            //�����Ԫ��
            queue.offerLast(i);
            //������ײ��ڴ����ڣ��򽫶��׵���
            while (queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            //��ʱnums[queue.peekFirst()]һ���Ǵ����е����ֵ
            ans[i - k + 1] = nums[queue.peekFirst()];
        }

        return ans;
    }
}