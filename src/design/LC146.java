package design;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU (Least Recently Used���������ʹ��) ����
 */
public class LC146 {

}

class LRUCache extends LinkedHashMap<Integer,Integer> {

    /**
     * ����
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
     * �ڵ���put����֮�󣬸÷����ᱻ���ã��ж��Ƿ���Ҫ�Ƴ��������ʹ�õ�ֵ��
     * (��LinkedHashMap�и÷���Ĭ�Ϸ���false)
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        //��С����������
        return size() > capacity;
    }
}
