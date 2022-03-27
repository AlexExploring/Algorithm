package JZOFII;

import java.util.*;

/**
 * 插入、删除和随机访问都是 O(1) 的容器
 */
public class JZ30 {

}

class RandomizedSet {

    List<Integer> list;
    Map<Integer,Integer> map;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);

        int idx = map.get(val); // 通过HashMap获取该元素在数组中的下标idx
        int lastNum = list.get(list.size() - 1); // 获取数组的最后一个元素
        list.set(idx, lastNum); // 将idx的值设为最后一个元素的值
        list.remove(list.size() - 1); // 删除最后一个元素,即等同于删除该元素
        map.put(lastNum, idx);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}