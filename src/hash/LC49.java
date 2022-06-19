package hash;

import java.util.*;

/**
 * ��ĸ��λ�ʷ��� ��ֻ����Сд��ĸ��
 *
 * LC438 �ҵ��ַ�����������ĸ��λ��
 */
public class LC49 {

    /**
     * ʹ��HashMap
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            //��һ��Ҳ����ͨ��ͳ��ÿ���ַ����ֵĴ������ٰ�˳���ַ�ƴ����������Ϊkey������leetcode����ֱ�������Ч�ʸ�
            Arrays.sort(array);
            //ʹ���������ַ�����Ϊkey
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
