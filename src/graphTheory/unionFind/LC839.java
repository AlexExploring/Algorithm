package graphTheory.unionFind;

/**
 * 相似的字符串
 */
public class LC839 {

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int[] parent = new int[n];
        //初始化parent数组
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int ans = n;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isSimilar(strs[i],strs[j])) {
                    if (union(parent,i,j)) ans--;
                }
            }
        }

        return ans;
    }

    public boolean union(int [] parent,int x,int y) {
        int px = find(parent,x);
        int py = find(parent,y);
        parent[px] = py;
        return px!=py;
    }

    public int find(int [] parent,int x) {
        if (parent[x] != x) parent[x] = find(parent,parent[x]);
        return parent[x];
    }

    /**
     * 判断两个字符串是否相似，只要小于等于两个位置的字符不相等，则两个字符串相似
     */
    public boolean isSimilar(String a,String b) {
        if (a.length() != b.length()) return false;

        for (int i = 0,count = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 2) return false;
            }
        }

        return true;
    }
}
