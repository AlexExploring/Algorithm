package heap;

import java.util.*;

public class LC347 {

    /**
     * ����һ:  С����  ά��һ����k��Ԫ�ص�С���ѣ������Ԫ�ش��ڶѶ�Ԫ�أ��򵯳��Ѷ�Ԫ�أ����ҽ��ϴ���Ǹ�ֵ���뵽С������
     */
    public int[] topKFrequent(int[] nums, int k) {
        // ʹ���ֵ䣬ͳ��ÿ��Ԫ�س��ֵĴ�����Ԫ��Ϊ����Ԫ�س��ֵĴ���Ϊֵ
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
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


    /**
     * ������: Ͱ����
     */
    public int[] topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // ʹ���ֵ䣬ͳ��ÿ��Ԫ�س��ֵĴ�����Ԫ��Ϊ����Ԫ�س��ֵĴ���Ϊֵ
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        //Ͱ����
        //��Ƶ����Ϊ�����±꣬���ڳ���Ƶ�ʲ�ͬ�����ּ��ϣ������Ӧ�������±�
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // ��ȡ���ֵĴ�����Ϊ�±�
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // ������������ȡ����˳��Ӵ�С������
        int [] ans = new int[k];
        int index = 0;
        for (int i = list.length-1; i >= 0 && index < k; i--) {
            if (list[i] == null) continue;
            for (int num : list[i]) {
                ans[index++] = num;
            }
        }

        return ans;
    }
}
