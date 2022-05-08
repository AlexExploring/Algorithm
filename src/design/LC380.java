package design;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取随机元素
 */
public class LC380 {
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

        //map 中存一个值，和该值在list中的下标
        map.put(val,list.size());
        //将val加入list的尾部
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int index = map.get(val); // 通过HashMap获取该元素在数组中的下标index
        int lastNum = list.get(list.size() - 1); // 获取数组的最后一个元素
        list.set(index, lastNum); // 将index处的值设为最后一个元素的值
        list.remove(list.size() - 1); // 删除最后一个元素,即等同于删除该元素
        map.put(lastNum, index);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        //随机获取
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}