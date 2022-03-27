package JZOFII;

import java.util.*;

/**
 * ±äÎ»´Ê×é
 */
public class JZ33 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }

        return new ArrayList<>(map.values());
    }
}
