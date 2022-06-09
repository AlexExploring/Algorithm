package graphTheory.topologicalSort;

import java.util.List;

public class Exercise {

    List<List<Integer>> edges;
    int [] visited;
    boolean valid = true;

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            }else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}