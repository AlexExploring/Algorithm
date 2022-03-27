package JZOFII;

import java.util.*;

/**
 * 和最小的k个数对
 */
public class JZ61 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int value1 = o1.get(0)+o1.get(1);
                int value2 = o2.get(0)+o2.get(1);
                if (value1 < value2) return 1;
                else if (value1 > value2) return -1;
                else return 0;
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (queue.size()==k) {
                    if ((nums1[i]+nums2[j]) < queue.peek().get(0)+queue.peek().get(1)) {
                        queue.poll();
                        queue.offer(Arrays.asList(nums1[i],nums2[j]));
                    }else break;
                }else {
                    queue.offer(Arrays.asList(nums1[i],nums2[j]));
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        k = Math.min(k,queue.size());
        for (int i = 0; i < k; i++) {
            ans.add(queue.poll());
        }

        return ans;
    }
}
