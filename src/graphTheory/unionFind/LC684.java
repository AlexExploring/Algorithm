package graphTheory.unionFind;

/**
 *
 */
public class LC684 {

    /**
     * 树是一个连通且无环的无向图，在树中多了一条边之后就会出现环，因此多余的边即为导致环出现的边。
     */
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        //parent 存储1~n这n个节点，此时每个节点的父节点都是自己
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        //遍历每一条边
        for (int i = 0; i < n; i++) {
            //当前遍历到的边
            int[] edge = edges[i];
            //组成边的两个点
            int node1 = edge[0], node2 = edge[1];
            //判断是否属于不同的连通分量
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }

        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    /**
     * 用于寻找父节点
     */
    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            //递归
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
