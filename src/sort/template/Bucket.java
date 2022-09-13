package sort.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Ͱ����
 */
public class Bucket {

    /**
     * �μ�LC347��Ŀ�������ֳ��ֵĴ�����Ϊlist���±꣬������Ϊlist��Ӧ�±�ĵ�ֵ
     */
    public int[] topKFrequent(int[] nums, int k) {
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
