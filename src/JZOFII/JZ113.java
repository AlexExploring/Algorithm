package JZOFII;

import java.util.ArrayList;
import java.util.List;

/**
 * �γ�˳��
 *
 * ��Ŀ���ͣ���������
 */
public class JZ113 {
    // �洢����ͼ
    List<List<Integer>> edges;
    // ���ÿ���ڵ��״̬��0=δ������1=�����У�2=�����
    int[] visited;
    // ��������ģ��ջ���±� n-1 Ϊջ�ף�0 Ϊջ��
    int[] result;
    // �ж�����ͼ���Ƿ��л�
    boolean valid = true;
    // ջ�±�
    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //���ݳ�ʼ��
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        //��֪��0 <= ��֪�γ̱�� < numCourses;
        //���prerequisites = [[1,0],[2,0],[3,1],[3,2]],numCourses = 4,��ôedges�д洢�Ľ���
        //[[1,2],[3],[3]];  �� 0 -> 1,0 -> 2,1 -> 3,2 -> 3;
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }
        visited = new int[numCourses];
        result = new int[numCourses];
        index = numCourses - 1;

        // ÿ����ѡһ����δ�������Ľڵ㣬����ͼ��û�л�,��ʼ���������������
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }

        if (!valid) {
            return new int[0];
        }

        // ���û�л�����ô������������
        return result;
    }

    public void dfs(int u) {
        // ���ڵ���Ϊ�������С�
        visited[u] = 1;
        // ���������ڽڵ�
        // ֻҪ�����л�������ֹͣ����
        for (int v: edges.get(u)) {
            // �����δ��������ô�������ڽڵ�
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            }
            // ����������С�˵���ҵ��˻�,�������������������еĵ�
            else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        // ���ڵ���Ϊ������ɡ�
        visited[u] = 2;
        // ���ڵ���ջ
        result[index--] = u;
    }
}
