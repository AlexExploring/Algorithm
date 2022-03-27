package AdvancedDataStructure.UnionFind;

import java.util.LinkedList;
import java.util.Queue;

/**
 *省份数量
 */
public class LC547 {
    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, provinces, i);
                circles++;
            }
        }
        return circles;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }

    public int findCircleNum1(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < provinces; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                circles++;
            }
        }
        return circles;
    }

    public int findCircleNum2(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] f = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            f[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(f, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (f[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public void union(int[] f, int index1, int index2) {//合并
        f[find(f, index1)] = find(f, index2);
    }

    public int find(int[] f, int index) {
        if (f[index] != index) {
            f[index] = find(f, f[index]);//带路径压缩的查找
        }
        return f[index];
    }
}
