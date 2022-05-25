package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ���ظ��ַ�����Ӵ�
 */
public class LC3 {

    /**
     * ʹ��set
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0,len = s.length();

        //˫��forѭ��ö����ʼλ��
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j));
                }else {
                    ans = Math.max(set.size(),ans);
                    set.clear();
                    break;
                }
            }
        }
        return Math.max(set.size(),ans);
    }

    /**
     * �����ظ��Ķ�set����clear����
     */
    public int lengthOfLongestSubstring1(String s) {
        // ��ϣ���ϣ���¼ÿ���ַ��Ƿ���ֹ�
        Set<Character> set = new HashSet<Character>();
        int len = s.length();

        // ��ָ�룬��ʼֵΪ -1���൱���������ַ�������߽����࣬��û�п�ʼ�ƶ�
        int rk = -1, ans = 0;
        for (int i = 0; i < len; ++i) {
            if (i != 0) {
                // ��ָ�������ƶ�һ���Ƴ�һ���ַ�
                set.remove(s.charAt(i - 1));
            }
            // �ж���һ���ַ��Ƿ��Ѿ���set��
            while (rk + 1 < len && !set.contains(s.charAt(rk + 1))) {
                // ���ϵ��ƶ���ָ��
                set.add(s.charAt(++rk));
            }
            // �� i �� rk ���ַ���һ�����������ظ��ַ��Ӵ�
            ans = Math.max(ans, rk - i + 1);
        }

        return ans;
    }

    /**
     * ����д����ʡȥ�˴�������Ҫ����ɾ�������Ӷ���ʡ�˴�����ʱ��
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            if(dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // ������ָ�� i����֤��������ʱ��i�ǵ�ǰ�ַ�������±�
            dic.put(s.charAt(j), j); // ��ϣ���¼
            res = Math.max(res, j - i); // ���½��
        }
        return res;
    }
}
