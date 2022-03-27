package JZOFII;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 *  替换单词
 */
public class JZ63 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Root root = new Root();
        for (int i = 0; i < dictionary.size(); i++) {
            root.insert(dictionary.get(i));
        }

        String [] beSplit = sentence.split("\\s");
        for (int i = 0; i < beSplit.length; i++) {
            String shortestPrefix = root.ShortestRoot(beSplit[i]);
            if (shortestPrefix != null) beSplit[i] = shortestPrefix;
        }

        System.out.println(Arrays.toString(beSplit));

        StringBuffer ans = new StringBuffer();
        for (String s : beSplit) {
            ans.append(s+" ");
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
        System.out.println(word);
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
            if (node.children[index].isEnd) break;
            node = node.children[index];
        }
        return ans.toString();
    }
}