package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * z
 */
public class LC3 {

    /**
     * 使用set
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, len = s.length();

        //双重for循环枚举起始位置
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                //添加失败说明有重复的值
                if (!set.add(s.charAt(j))) {
                    ans = Math.max(set.size(), ans);
                    set.clear();
                    break;
                }
            }
        }
        return Math.max(set.size(), ans);
    }

    /**
     * 避免重复的对set进行clear操作
     */
    public int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<Character>();
        int len = s.length();

        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int r = -1, ans = 0;
        for (int i = 0; i < len; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除之前窗口中最左边的字符
                set.remove(s.charAt(i - 1));
            }
            // 判断下一个字符是否已经在set中
            while (r + 1 < len && !set.contains(s.charAt(r + 1))) {
                // 不断地移动右指针,在窗口右侧添加元素
                set.add(s.charAt(++r));
            }
            // 第 i 到 r 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, r - i + 1);
        }

        return ans;
    }

    /**
     * 使用map记录字符对应的下标
     *
     * 这种写法，省去了大量不必要的增删操作，从而节省了大量的时间
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, ans = 0;

        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                // 更新左指针 i，保证计算结果的时候，i是当前字符的最大下标
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            dic.put(s.charAt(j), j); // 哈希表记录
            ans = Math.max(ans, j - i); // 更新结果
        }

        return ans;
    }
}
