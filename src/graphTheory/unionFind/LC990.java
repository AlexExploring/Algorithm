package graphTheory.unionFind;

/**
 * 等式方程的可满足性 相关题目（LC399）
 */
public class LC990 {

    public boolean equationsPossible(String[] equations) {
        int [] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent,index1,index2);
            }
        }

        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent,index1) == find(parent,index2)) {
                    return false;
                }
            }
        }

        return true;
    }

    public void union(int [] parent,int x,int y) {
        int px = find(parent,x);
        int py = find(parent,y);
        parent[px] = py;
    }

    public int find(int [] parent,int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
