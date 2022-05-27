package slidingWindow;

import java.util.*;

/**
 *�������ڵ����ֵ
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
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //����һ���ڲ��Ƚ���
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                //���ݶ�Ӧ�ıȽ�����������õ����� �����
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        //�ȼ�¼��һ�����������е�ֵ
        //��¼��ֵ��һ����Ԫ�� �ֱ���Ԫ�ص� ֵ��Ԫ���������ж�Ӧ���±�
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        // ����ֻ��Ҫ�ж� ���ȶ����ж�Ӧ�����ֵ���±��Ƿ��� ��������У�����ڣ�����������е����ֵ
        // �������ȶ��еĶ����Ӧ��ֵ��
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {//���ֵ��Ӧ���±겻�ڴ����У��򽫵�ǰ�����ֵ�����ȶ�����ɾ��
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    /**
     * ʹ�õ�������
     *
     * ����������У�����洢�����±꣬��Щ�±갴�մ�С�����˳�򱻴洢��
     * ��������������nums�ж�Ӧ��ֵ���ϸ񵥵��ݼ��ġ�
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length==0) return new int[0];
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        System.out.println(Arrays.toString(deque.toArray()));

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()]; //���״洢���±���Ƕ�Ӧ�����е����ֵ��Ӧ���±�
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);//�����Ԫ��
            while (deque.peekFirst() <= i - k) {//������ײ��ڴ����ڣ��򽫶��׵���
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

}