package graphTheory.topologicalSort;

import java.util.ArrayList;
import java.util.List;

/**
 * �������ֵ� (��JZII 114��ͬ)
 */
public class LC269 {
    public String alienOrder(String[] words) {
        int n = words.length;
        List<List<Integer>> edges = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            edges.add(new ArrayList<>());
        }
        int [] inDegree = new int[26];

        return null;
    }
}
