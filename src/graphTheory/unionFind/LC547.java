package graphTheory.unionFind;

/**
 * 省份数量 (和LC839类似)
 */
public class LC547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int ans = n;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    if (union(parent,i,j)) ans--;
                }
            }
        }
        return ans;
    }

    /**
     * 用于寻找父节点，并压缩路径
     */
    public int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    public boolean union(int[] parent, int x, int y) {
        int px = find(parent,x);
        int py = find(parent,y);
        parent[px] = py;
        return px != py;
    }
}
