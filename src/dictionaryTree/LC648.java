package dictionaryTree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  替换单词
 */
public class LC648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        // 建立字典树
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
     * 前缀哈希
     */
    public String replaceWords1(List<String> roots, String sentence) {
        Set<String> set = new HashSet();
        for (String root: roots) set.add(root);

        StringBuilder ans = new StringBuilder();
        for (String word: sentence.split("\\s+")) {
            String prefix = null;
            //截取每个单词中的前i个字符，判断set中是否存在对应的前缀
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
        isEnd = false; //用来标识是否有一个完整的单词
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
            //遇到可以结束的点，就，break，确保最短前缀
            if (node.children[index].isEnd) break;
            node = node.children[index];
        }
        return ans.toString();
    }
}