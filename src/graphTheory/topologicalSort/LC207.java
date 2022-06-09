package graphTheory.topologicalSort;

import java.util.ArrayList;
import java.util.List;

/**
 * �γ̱� �����Ŀ��LC210 �γ̱�II��
 */
public class LC207 {

    // �洢����ͼ
    List<List<Integer>> edges;
    // ���ÿ���ڵ��״̬��0=δ������1=�����У�2=�����
    int[] visited;
    // �ж�����ͼ�Ƿ�Ϊ�޻�ͼ,Ϊtrue��ʾ�޻�
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //���ݳ�ʼ�� ʹ��edges���洢���еı�
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];

        //��֪��0 <= ��֪�γ̱�� < numCourses;
        //���prerequisites = [[1,0],[2,0],[3,1],[3,2]],numCourses = 4,��ôedges�д洢�Ľ���
        //[[1,2],[3],[3]];  �� 0 -> 1,0 -> 2,1 -> 3,2 -> 3;
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }

        // ÿ����ѡһ����δ�������Ľڵ㣬����ͼ��û�л�,��ʼ���������������
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        return valid;
    }

    /**
     * ʹ��dfs����������������
     */
    public void dfs(int u) {
        // ���ڵ���Ϊ�������С�
        visited[u] = 1;
        // ���������ڽڵ�,ֻҪ�����л�������ֹͣ����
        for (int v: edges.get(u)) {
            // �����δ��������ô�������ڽڵ�
            if (visited[v] == 0) {
                dfs(v);
                //��֦������Ҳ�ɲ�д
                if (!valid) {
                    return;
                }
                // ����������С�˵���ҵ��˻�,�������������������еĵ�
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        // ���ڵ���Ϊ������ɡ�
        visited[u] = 2;
    }
}
