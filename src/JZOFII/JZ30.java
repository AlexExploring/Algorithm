package JZOFII;

import java.util.*;

/**
 * ���롢ɾ����������ʶ��� O(1) ������
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

        int idx = map.get(val); // ͨ��HashMap��ȡ��Ԫ���������е��±�idx
        int lastNum = list.get(list.size() - 1); // ��ȡ��������һ��Ԫ��
        list.set(idx, lastNum); // ��idx��ֵ��Ϊ���һ��Ԫ�ص�ֵ
        list.remove(list.size() - 1); // ɾ�����һ��Ԫ��,����ͬ��ɾ����Ԫ��
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