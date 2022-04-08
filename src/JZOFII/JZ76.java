package JZOFII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * �����е�K�������
 *
 * ��LC215��ͬ
 */
public class JZ76 {

    /**
     * ����
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * ��������
     */
    public int findKthLargest1(int[] nums, int k) {

        return 0;
    }


    /**
     * ʹ�����ȶ���
     */
    public int findKthLargest2(int[] nums, int k) {
        //����һ����СΪk�Ĵ����
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