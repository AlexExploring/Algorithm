package graphTheory.unionFind;

/**
 *
 */
public class LC684 {

    /**
     * ����һ����ͨ���޻�������ͼ�������ж���һ����֮��ͻ���ֻ�����˶���ı߼�Ϊ���»����ֵıߡ�
     */
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        //parent �洢1~n��n���ڵ㣬��ʱÿ���ڵ�ĸ��ڵ㶼���Լ�
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        //����ÿһ����
        for (int i = 0; i < n; i++) {
            //��ǰ�������ı�
            int[] edge = edges[i];
            //��ɱߵ�������
            int node1 = edge[0], node2 = edge[1];
            //�ж��Ƿ����ڲ�ͬ����ͨ����
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
     * ����Ѱ�Ҹ��ڵ�
     */
    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            //�ݹ�
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
