package design;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU (Least Recently Used，最近最少使用) 缓存
 */
public class LC146 {

}

class LRUCache extends LinkedHashMap<Integer,Integer> {

    /**
     * 容量
     */
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    /**
     * 在调用put方法之后，该方法会被调用，判断是否需要移除最近最少使用的值。
     * (在LinkedHashMap中该方法默认返回false)
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        //大小超过容量，
        return size() > capacity;
    }
}
