package sort.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 桶排序
 */
public class Bucket {

    /**
     * 参见LC347题目，将数字出现的次数作为list的下标，数字作为list对应下标的的值
     */
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排列
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
