package graphTheory.topologicalSort;

import java.util.*;

/**
 * �������ֵ�
 */
public class LC269 {
    public String alienOrder(String[] words) {
        int n = words.length;
        List<List<Integer>> graph = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        int [] degree = new int[26];
        //����Ҫȫ���ȳ�ʼ��Ϊ-1����Ϊwords�п��ܲ���ĳЩ�ַ�
        Arrays.fill(degree,-1);
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                degree[word.charAt(i) - 'a'] = 0;
            }
        }

        //��ͼ
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int len1 = words[i].length(), len2 = words[j].length();
                int m = Math.min(len1,len2);
                // ͨ�������ַ����ж��������ַ������ַ����ֵ���
                for (int k = 0; k < m; k++) {
                    char ch1 = words[i].charAt(k), ch2 = words[j].charAt(k);
                    if (ch1 == ch2) {
                        if (k == m-1 && len1 > len2) return "";
                        continue;
                    }
                    graph.get(ch1 - 'a').add(ch2 - 'a');
                    ++degree[ch2 - 'a'];
                    break;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                ans.append((char) (i + 'a'));
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j : graph.get(i)) {
                --degree[j];
                if (degree[j] == 0) {
                    queue.offer(j);
                    ans.append((char) (j + 'a'));
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (degree[i] > 0) return "";
        }

        return ans.toString();
    }
}
