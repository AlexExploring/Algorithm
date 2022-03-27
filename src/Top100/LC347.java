package Top100;

import sun.awt.image.IntegerInterleavedRaster;

import java.util.*;

public class LC347 {
    /**
     * ����һ ��ֱ������Ȼ������ȡǰk��Ԫ��
     */


    /**
     * ������ ʹ�����ȶ���   ���������
     */
    public int[] topKFrequent(int[] nums, int k) {
         class data{
            private int num;
            private int value;

             public data(int num, int value) {
                 this.num = num;
                 this.value = value;
             }
         }
        Comparator<data> cData = new Comparator<data>() {
            @Override
            public int compare(data o1, data o2) {
                if (o1.value<o2.value) return 1;
                else if (o1.value>o2.value) return -1;
                else {
                    if (o1.num<o2.num) return -1;
                    else if (o1.num>o2.num) return 1;
                    else return 0;
                }
            }
        };
        PriorityQueue<data> queue = new PriorityQueue<>(cData);

        Arrays.sort(nums);
        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i+1<nums.length&&nums[i+1]!=nums[i]){
                queue.add(new data(nums[i],i-start));
                System.out.println("start="+start+" end="+i);
                start = i;
            }
        }
        queue.add(new data(nums[nums.length-1],nums.length-1-start));

        int [] ans = new int[k];
        int index = 0;
        while (k-->0&&!queue.isEmpty()){
            ans[index++] = queue.poll().num;
        }

        return ans;
    }

    /**
     * ������  С����  ά��һ����k��Ԫ�ص�С���ѣ������Ԫ�ش��ڶѶ�Ԫ�أ��򵯳��Ѷ�Ԫ�أ����ҽ��ϴ���Ǹ�ֵ���뵽С������
     */

    public int[] topKFrequent1(int[] nums, int k) {
        // ʹ���ֵ䣬ͳ��ÿ��Ԫ�س��ֵĴ�����Ԫ��Ϊ����Ԫ�س��ֵĴ���Ϊֵ
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // ����map������С�ѱ���Ƶ������k��Ԫ��
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // ȡ����С���е�Ԫ��
        int [] ans = new int[k];
        int index = 0;
        while (!pq.isEmpty()) {
            ans[index++] = pq.remove();
        }
        return ans;
    }

}
