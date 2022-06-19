package hash;

import java.util.*;

/**
 * 字母异位词分组 （只包含小写字母）
 *
 * LC438 找到字符串中所有字母异位词
 */
public class LC49 {

    /**
     * 使用HashMap
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            //这一步也可以通过统计每个字符出现的次数，再按顺序将字符拼接起来，作为key，但在leetcode不如直接排序的效率高
            Arrays.sort(array);
            //使用排序后的字符串作为key
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
