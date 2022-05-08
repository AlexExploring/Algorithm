package hash;

import java.util.HashMap;

/**
 * ��֤������ʵ�
 */
public class LC953 {

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }

        for (int i = 1; i < words.length; i++) {
            //һ���ж��������ʵ��ֵ����Ƿ���� order��˳��
            String pre = words[i-1];
            String cur = words[i];
            int n = Math.min(pre.length(),cur.length());

            int flag = 0;
            int j;
            for (j = 0; j < n; j++) {
                // �����ֵ���Ҫ��ֱ��break
                if (map.get(pre.charAt(j)) < map.get(cur.charAt(j))) {
                    break;
                }
                // ��ʱ�����ֵ���Ҫ�󣬿�����Ҫ�����жϣ���flag = 1;
                else if (map.get(pre.charAt(j)) == map.get(cur.charAt(j))) {
                    flag = 1;continue;
                }
                // �������ֵ���Ҫ��ֱ�� return false����
                else if (map.get(pre.charAt(j)) > map.get(cur.charAt(j))) {
                    return false;
                }
            }

            //������ĿҪ�������ַ������Ȳ���ȣ�ǰn���ַ�����ͬʱ�����Ƚ�С���ַ������ֵ���Ӧ�ø�С
            if (j==n&&flag==1&&pre.length()>cur.length()) {
                return false;
            }
        }

        return true;
    }
}
