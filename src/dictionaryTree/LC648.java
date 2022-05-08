package dictionaryTree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  �滻����
 */
public class LC648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        // �����ֵ���
        Root root = new Root();
        for (int i = 0; i < dictionary.size(); i++) {
            root.insert(dictionary.get(i));
        }

        String [] beSplit = sentence.split("\\s");
        for (int i = 0; i < beSplit.length; i++) {
            String shortestPrefix = root.ShortestRoot(beSplit[i]);
            if (shortestPrefix != null) beSplit[i] = shortestPrefix;
        }

        StringBuffer ans = new StringBuffer();
        for (String s : beSplit) {
            ans.append(s+" ");
        }

        return ans.toString().trim();
    }

    /**
     * ǰ׺��ϣ
     */
    public String replaceWords1(List<String> roots, String sentence) {
        Set<String> set = new HashSet();
        for (String root: roots) set.add(root);

        StringBuilder ans = new StringBuilder();
        for (String word: sentence.split("\\s+")) {
            String prefix = null;
            //��ȡÿ�������е�ǰi���ַ����ж�set���Ƿ���ڶ�Ӧ��ǰ׺
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (set.contains(prefix)) break;
            }
            ans.append(prefix+" ");
        }

        return ans.toString().trim();
    }
}

class Root {
    private Root [] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Root() {
        children = new Root[26];
        isEnd = false; //������ʶ�Ƿ���һ�������ĵ���
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Root node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Root();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public String ShortestRoot(String prefix) {
        return searchPrefix(prefix);
    }

    private String searchPrefix(String prefix) {
        Root node = this;
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            ans.append(ch);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            //�������Խ����ĵ㣬�ͣ�break��ȷ�����ǰ׺
            if (node.children[index].isEnd) break;
            node = node.children[index];
        }
        return ans.toString();
    }
}