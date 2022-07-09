package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ���ظ��ַ�����Ӵ�
 *
 * z
 */
public class LC3 {

    /**
     * ʹ��set
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, len = s.length();

        //˫��forѭ��ö����ʼλ��
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                //���ʧ��˵�����ظ���ֵ
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
     * �����ظ��Ķ�set����clear����
     */
    public int lengthOfLongestSubstring1(String s) {
        // ��ϣ���ϣ���¼ÿ���ַ��Ƿ���ֹ�
        Set<Character> set = new HashSet<Character>();
        int len = s.length();

        // ��ָ�룬��ʼֵΪ -1���൱���������ַ�������߽����࣬��û�п�ʼ�ƶ�
        int r = -1, ans = 0;
        for (int i = 0; i < len; ++i) {
            if (i != 0) {
                // ��ָ�������ƶ�һ���Ƴ�֮ǰ����������ߵ��ַ�
                set.remove(s.charAt(i - 1));
            }
            // �ж���һ���ַ��Ƿ��Ѿ���set��
            while (r + 1 < len && !set.contains(s.charAt(r + 1))) {
                // ���ϵ��ƶ���ָ��,�ڴ����Ҳ����Ԫ��
                set.add(s.charAt(++r));
            }
            // �� i �� r ���ַ���һ�����������ظ��ַ��Ӵ�
            ans = Math.max(ans, r - i + 1);
        }

        return ans;
    }

    /**
     * ʹ��map��¼�ַ���Ӧ���±�
     *
     * ����д����ʡȥ�˴�������Ҫ����ɾ�������Ӷ���ʡ�˴�����ʱ��
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, ans = 0;

        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                // ������ָ�� i����֤��������ʱ��i�ǵ�ǰ�ַ�������±�
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            dic.put(s.charAt(j), j); // ��ϣ���¼
            ans = Math.max(ans, j - i); // ���½��
        }

        return ans;
    }
}
