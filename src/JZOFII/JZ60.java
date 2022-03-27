package JZOFII;

import java.util.*;

/**
 * 出现频率最高的 k 个数字
 */
public class JZ60 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        class numNode {
            private int num;
            private int occurTimes;

            public numNode(int num, int occurTimes) {
                this.num = num;
                this.occurTimes = occurTimes;
            }
        }

        numNode [] numOccurTimes = new numNode[map.size()];
        int index = 0;
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            numOccurTimes[index++] = new numNode(entry.getKey(),entry.getValue());
        }

        PriorityQueue<numNode> numOccurQueue = new PriorityQueue<>(new Comparator<numNode>() {
            @Override
            public int compare(numNode o1, numNode o2) {
                if (o1.occurTimes < o2.occurTimes) return -1;
                else if (o1.occurTimes > o2.occurTimes) return 1;
                else return 0;
            }
        });

        for (numNode ele : numOccurTimes) {
            if (numOccurQueue.size() == k) {
                if (numOccurQueue.peek().occurTimes< ele.occurTimes){
                    numOccurQueue.poll();
                    numOccurQueue.offer(ele);
                }
            }else {
                numOccurQueue.offer(ele);
            }
        }

        int [] ans = new int[k];
        index = 0;
        for (numNode numNode : numOccurQueue) {
            ans[index++] = numNode.num;
        }

        return ans;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
