package Top100;

import java.util.ArrayList;
import java.util.List;

/**
 * �γ̱�
 *
 * ��������
 *
 * prerequisites[i] = {a,b};
 */
public class LC207 {
    List<List<Integer>> edges;
    int [] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        // �洢��,���ս��Ϊprerequisite[i] �д洢���� i ��ֱ�ӵ�������������ڵ�
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v : edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            }else if (visited[v] == 1) { //˵���л�������������������
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
